import java.io.*;
import java.util.*;

class Number implements Comparable<Number> {
    int idx, val;

    public Number(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(val, o.val);
    }

    @Override
    public String toString() {
        return "Number{" +
                "idx=" + idx +
                ", val=" + val +
                '}';
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Number[] numbers = new Number[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(numbers);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[numbers[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
    }
}
