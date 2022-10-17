import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int key) {
        if (key == m) {
            for (int v : arr) sb.append(v).append(" ");
            sb.append('\n');
            return ;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[key] = i + 1;
                dfs(key + 1);
                visited[i] = false;
            }
        }
    }
}
