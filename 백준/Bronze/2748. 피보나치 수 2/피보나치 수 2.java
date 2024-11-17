import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long res = fib(num);
        pw.println(res);
        pw.close();
        br.close();
    }

    public static long fib(int n) {
        if(n <= 0) return 0;
        long n1 = 0;
        long n2 = 1;
        long[] tmp = new long[n+1];
        tmp[0] = 0;
        tmp[1] = 1;
        for (int i = 2; i <= n; i++) {
            tmp[i] = n1 + n2;
            n1 = n2;
            n2 = tmp[i];
        }
        return tmp[n];
    }
}