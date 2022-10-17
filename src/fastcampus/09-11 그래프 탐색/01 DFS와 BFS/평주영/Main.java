import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken()) - 1;

        graph = new boolean[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            graph[v1][v2] = graph[v2][v1] = true;
        }

        dfs(V);
        Arrays.fill(visited, false);
        sb.append('\n');
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v + 1).append(' ');

        for (int i = 0; i < N; i++) {
            if (graph[v][i] && !visited[i]) {
                dfs(i);
            }
        }

    }

    private static void bfs(int v) {
        visited[v] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int u = queue.remove();
            sb.append(u + 1).append(' ');

            for (int i = 0; i < N; i++) {
                if (graph[u][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
