import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int right = Integer.MIN_VALUE;
    static int left = 1;
    static int N;
    static int M;
    static int[] arr;
    static int mid, 몫, 나머지, ppl;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];


        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            right = Integer.max(right, input);
        }

        while(left <= right){
            mid = (left + right) / 2;
            ppl = 0;
            for (int i = 0; i < arr.length; i++) {
                몫 = arr[i] / mid;
                나머지 = arr[i] % mid;
                ppl += 몫;
                if(나머지 != 0){
                    ppl ++;
                }
            }
            if(ppl > N){ // min 낮아짐 min 올릴 필요있음;
                left = mid + 1;
            } else { // min 높아짐 min 내릴 필요있음;
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        pw.println(answer);

        pw.close();
        br.close();
    }
}