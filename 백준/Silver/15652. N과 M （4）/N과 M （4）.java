import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] ans;
    static int N;
    static int M;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        NM(0,0, pw);

        br.close();
        pw.close();
    }

    private static void NM(int cnt, int start, PrintWriter pw) {
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]);
                if(i < M-1){
                    sb.append(" ");
                }
            }
            pw.println(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            ans[cnt] = arr[i];
            NM(cnt+1, i,  pw);
        }
    }
}
