import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int sInx = 0;
        int lInx = N-1;
        int cnt = 0;

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        while (true) {
            if(sInx>=lInx){
                break;
            }
            int sum = 0;
            sum = arr[sInx] + arr[lInx];
            if(sum < M){
                sInx++;
            }
            else if(sum > M){
                lInx--;

            }
            else{
                sInx++;
                lInx--;
                cnt++;
            }
        }
        pw.print(cnt);

        br.close();
        pw.close();
    }
}
