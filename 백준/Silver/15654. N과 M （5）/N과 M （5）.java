import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        isVisit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        nm(arr, 0, pw);
        pw.close();
        br.close();
    }

    public static void nm(int[] arr, int cnt, PrintWriter pw){
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for(int i : ans){
                sb.append(i);
                sb.append(" ");
            }
            pw.println(sb);
            cnt = 0;
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!isVisit[i]){
                ans[cnt] = arr[i];
                isVisit[i] = true;
                nm(arr, cnt+1, pw);
                isVisit[i] = false;
            }
        }
    }
}
