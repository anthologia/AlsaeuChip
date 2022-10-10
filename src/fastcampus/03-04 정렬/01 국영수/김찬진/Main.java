import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person>{
    String name;
    int kor, eng, math;

    Person(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int compareTo(Person that) {
        if(this.kor > that.kor) {
            return -1;
        }
        else if(this.kor == that.kor) {
            if(this.eng < that.eng) {
                return -1;
            }
            else if(this.eng == that.eng) {
                if(this.math > that.math) {
                    return -1;
                }
                else if(this.math == that.math) {
                    return this.name.compareTo(that.name);
                }
            }
        }
        return 1;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Person[] pAry = new Person[n]; // Person 객체 n개 생성

        for(int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            pAry[i] = new Person(s[0],
                    Integer.valueOf(s[1]),
                    Integer.valueOf(s[2]),
                    Integer.valueOf(s[3]));
        }

        Arrays.sort(pAry); // 오름차순 정렬

        for(Person p : pAry) {
            sb.append(p.name + p.kor + "\n");
        }
        System.out.println(sb);
    }
}
