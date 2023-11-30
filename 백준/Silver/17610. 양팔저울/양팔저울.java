import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], position[], ans[], count[], sum, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ans = new int[N];
        position = new int[]{-1, 1, 0};
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = 0;
        answer = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            sum += input;
        }
        count = new int[sum];

        recursion(0);

        for (int i = 0; i < count.length; i++) {
            if(count[i] == 0){
                answer++;
            }
        }

        pw.println(answer);

        br.close();
        pw.close();
    }

    public static void recursion(int cnt){
        if(cnt == N){
//            for (int i = 0; i < ans.length; i++) {
//                System.out.print(ans[i] + " ");
//            }
//            System.out.println();
            // ans 꺼내쓰기
            int result = 0;
            for (int i = 0; i < N; i++) {
                result += arr[i] * ans[i];
            }
            result = Math.abs(result);
            if(1 <= result && result <= sum){
                count[result-1]++;
            }
            return;
        }
        for (int i = 0; i < position.length; i++) {
            ans[cnt] = position[i];
            recursion(cnt+1);
        }
    }
}
