import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] liquids = new int[n];

        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquids);

        int start = 0;
        int last = n - 1;
        int diff = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        int sum, abs;
        while (start < last) {
            sum = liquids[start] + liquids[last];
            abs = Math.abs(sum);
            if (abs < diff) {
                diff = abs;
                ans1 = start;
                ans2 = last;
            }

            if (sum > 0) last--;
            else start++;
        }
        System.out.println(liquids[ans1] + " " + liquids[ans2]);
    }
}
