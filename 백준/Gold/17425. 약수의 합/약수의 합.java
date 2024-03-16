import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        int max = 1000000;
        long[] d = new long[max+1];
        for (int i = 0; i <= max; i++) {
            d[i] = 1;
        }
        long sumArr[] = new long[max+1];
        for (int i = 2; i <= max; i++) {
            for (int j = 1; i*j <= max; j++) {
                d[i*j] += i;
            }
        }

        for (int i = 1; i <= max; i++) {
            sumArr[i] += sumArr[i-1] + d[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            pw.println(sumArr[N]);
        }
        pw.close();
    }
}
