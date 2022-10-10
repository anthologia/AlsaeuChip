import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static void input() {
        FastReader scan = new FastReader();
        //N과 M 입력받고
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1]; //selected 배열은 M번째 까지 필요해서 M+1
    }

    static int N, M;
    static int[] selected;

    static void rec_func(int k) {
        if (k == M + 1) {

            //찾았던 selected배열을 for문을 돌려서 검색된 결과를 출력해준다.
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            //이번에 넣을 숫자를 canddata라고 하면 canddata가 1부터n까지 차례대로 적용될 것임
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                //k+1 번 ~ M번 을 모두 탐색
                rec_func(k + 1);
                //탐색이 끝나면 더이상 원소를 기록에 남길 필요가 없기 때문에 0
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
            input();

            //k를 1로 넘겨주면 알아서 정답을 다 구해올 거라는 믿음이..? 있다..
            rec_func(1);
            System.out.println(sb.toString());
        }
        static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public FastReader(String s) throws FileNotFoundException {
                br = new BufferedReader(new FileReader(new File(s)));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }
    }
