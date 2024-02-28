import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean check[];
    static int board[][], N, M;
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken())+1;
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        board= new int [N][N];
        check = new boolean[N];



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from][to] = 1;
            board[to][from] = 1;
        }

        dfs(start);
        System.out.println();
        check = new boolean[N];
        bfs(start);
    }


    static public void dfs(int start){
        check[start] = true;
        System.out.printf("%d ", start);
        for (int i = 0; i < N; i++) {
            if(board[start][i] == 1 && !check[i]){
                dfs(i);
            }
        }
    }

    static public void bfs(int start){
        que.add(start);
        check[start] = true;
        while(!que.isEmpty()){
            start = que.poll();
            System.out.printf("%d ", start);
            for (int i = 0; i < N; i++) {
                if(board[start][i] == 1 && !check[i]){
                    que.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
