import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static boolean map[][], visit[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        map = new boolean[n][n];
        visit = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int fi = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            map[fi][to] = true;
            map[to][fi] = true;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int detectLocation) {
        int start = detectLocation;
        visit[start] = true;
        for (int i = 0; i < n; i++) {
            if(!visit[i] && map[start][i]) {
                visit[i] = true;
                dfs(i);
            }
        }
    }
}
