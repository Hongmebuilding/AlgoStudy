import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        nm(0, pw, 0);
        br.close();
        pw.close();
    }

    static void nm(int cnt, PrintWriter pw, int start){
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for (int i : ans){
                sb.append(i);
                sb.append(" ");
            }
            pw.println(sb);
            cnt = 0;
            return;
        }

        for (int i = start; i < N; i++) {
            ans[cnt] = arr[i];
            nm(cnt+1, pw, i);
        }
    }
}
