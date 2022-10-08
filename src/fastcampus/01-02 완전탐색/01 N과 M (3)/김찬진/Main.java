import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int key) {
        if(key == M){
            for (int v : arr) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                arr[key] = i;
                dfs(key + 1);
            }
        }
    }
}