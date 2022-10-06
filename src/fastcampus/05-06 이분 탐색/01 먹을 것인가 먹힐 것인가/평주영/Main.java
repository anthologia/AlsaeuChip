import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer[] A, B;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            A = makeArray(N);
            B = makeArray(M);

            Arrays.sort(A);
            Arrays.sort(B, Comparator.reverseOrder());

            int sum = calcFeedCnt();
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    public static Integer[] makeArray(int n) throws IOException {
        Integer[] arr = new Integer[n];
        String[] tmp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        return arr;
    }

    public static int calcFeedCnt() {
        int sum = 0;
        for (int a : A) {
            for (int i = 0; i < B.length; i++) {
                if (a > B[i]) {
                    sum += B.length - i;
                    break;
                }
            }
        }
        return sum;
    }
}
