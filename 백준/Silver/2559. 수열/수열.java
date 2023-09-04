
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N+1];
        int max = Integer.MIN_VALUE;

        array[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = array[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-K+1; i++) {
            int sum = array[i+K] - array[i];
            if(max < sum){
                max = sum;
            }
        }

        pw.println(max);
        
        pw.close();
        br.close();
    }
}
