import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String[] data) {
        this.name = data[0];
        this.kor = Integer.parseInt(data[1]);
        this.eng = Integer.parseInt(data[2]);
        this.math = Integer.parseInt(data[3]);
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        int compareKor = Integer.compare(o.kor, this.kor);
        if (compareKor != 0) {
            return compareKor;
        }

        int compareEng = Integer.compare(this.eng, o.eng);
        if (compareEng != 0) {
            return compareEng;
        }

        int compareMath = Integer.compare(o.math, this.math);
        if (compareMath != 0) {
            return compareMath;
        }

        return this.name.compareTo(o.name);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Student> students = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            students.add(new Student(br.readLine().split(" ")));
        }

        while (!students.isEmpty()) {
            sb.append(students.poll().getName()).append('\n');
        }

        System.out.println(sb);
    }
}
