import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int twoSum = Integer.parseInt(br.readLine());

        int LIdx = 0;
        int RIdx = n - 1;
        int cnt = 0;

        while (RIdx >= 0 && LIdx < n && RIdx > LIdx) { 
            if(RIdx == LIdx){
                break;
            }
            int sum = arr[LIdx] + arr[RIdx];
            if (sum > twoSum) {
                RIdx--;
            } else if (sum < twoSum) {
                LIdx++;
            } else {
                cnt++;
                LIdx++;
                RIdx--;
            }
        }
        pw.println(cnt);

        pw.close();
        br.close();
    }
}
