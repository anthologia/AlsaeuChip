import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static String[][] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.next();
            }
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {

                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                        if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {

                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);// 내림차순

                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);// 오름차순
                }

                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); // 내림차순

            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0]);
        }
    }

}