import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new PrintWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            cnt[number]++;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= cnt[i] ; j++) { // 숫자만큼 반복출력
                pw.println(i);
            }
        }

        pw.close();
        br.close();
    }
}