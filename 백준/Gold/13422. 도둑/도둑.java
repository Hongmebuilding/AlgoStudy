import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());//몇가구
            int M = Integer.parseInt(st.nextToken());//연속된수
            int K = Integer.parseInt(st.nextToken());//최소돈의양
            int arr[] = new int[2 * N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                arr[j + N] = arr[j];
            }

            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[j];
            }
            if (sum < K) {
                cnt++;
            }

            if (N > M) {
                for (int j = 1; j < N; j++) {
                    sum -= arr[j - 1];
                    sum += arr[j + M - 1];
                    if (sum < K) {
                        cnt++;
                    }
                }
            }
            pw.println(cnt);
        }

        br.close();
        pw.close();
    }
}