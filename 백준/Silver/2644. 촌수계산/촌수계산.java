import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, relatives[], count[], map[][];
    static boolean[] visit;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        relatives = new int[2];
        relatives[0] = Integer.parseInt(st.nextToken());
        relatives[1] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;
        }
        q = new LinkedList<>();
        count = new int[n+1];
        visit = new boolean[n+1];

        bfs();
    }

    private static void bfs() {
        q.add(relatives[0]);
        visit[relatives[0]] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == relatives[1]){
                System.out.println(count[node]);
                break;
            }
            for (int i = 1; i <= n; i++) {
                if(!visit[i] && map[node][i]==1){
                    q.offer(i);
                    visit[i] = true;
                    count[i] = count[node]+1;
                }
            }
        }
        if (!visit[relatives[1]]) {
            System.out.println(-1);
        }
    }
}
