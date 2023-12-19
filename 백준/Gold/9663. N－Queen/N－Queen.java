import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main
{
    static int N, arr[][], dx[], dy[], cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dx = new int[]{1,1,0,-1,-1,-1,0,1};
        dy = new int[]{0,-1,-1,-1,0,1,1,1};
        cnt = 0;

        NQueen(0);

        pw.print(cnt);
        br.close();
        pw.close();
    }

    public static void NQueen(int rowIdx){
        if(rowIdx == N){
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(arr[rowIdx][i] == 0){
                arr[rowIdx][i] = -1;
                moveQueen(rowIdx, i, 1);
                NQueen(rowIdx+1);
                arr[rowIdx][i] = 0;
                moveQueen(rowIdx, i, -1);
            }
        }
    }

    private static void moveQueen(int rowIdx, int i, int value) {
        for (int j = 0; j < 8; j++) {
            int tx = dx[j] + i;
            int ty = dy[j] + rowIdx;
            while(0 <= tx && tx < N && 0 <= ty && ty < N){
                arr[ty][tx] += value;
                tx += dx[j];
                ty += dy[j];
            }
        }
    }
}
