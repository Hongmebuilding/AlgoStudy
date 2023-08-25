import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        for (int i = 0; i < N-K+1; i++) {
            int sum = 0;
            for (int j = i; j < K + i; j++) {
                sum += list.get(j);
            }
            if(sum > max){
                max = sum;
            }
        }

        pw.println(max);

        pw.close();
        br.close();
    }
}
