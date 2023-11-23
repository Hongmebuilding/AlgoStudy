import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[] answer;
    static boolean[] isVisited;
    static int num[];
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        answer = new int[M];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = i+1;
        }
        
        NM(0, pw);
        pw.close();
        br.close();
    }

    private static void NM(int cnt, PrintWriter pw) {
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]);
                sb.append(" ");
            }
            pw.println(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            answer[cnt] = num[i];
            NM(cnt+1, pw);
        }
    }
}
