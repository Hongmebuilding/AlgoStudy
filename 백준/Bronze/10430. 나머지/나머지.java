import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        PrintWriter pw = new PrintWriter(System.out);
        pw.println((A+B)%C);
        pw.println(((A%C) + (B%C))%C);
        pw.println((A*B)%C);
        pw.println(((A%C) * (B%C))%C);
        pw.close();
    }
}
