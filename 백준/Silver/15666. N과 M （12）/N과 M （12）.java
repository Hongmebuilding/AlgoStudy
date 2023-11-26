import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int arr[], ans[], N, M;

    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        nm(arr, 0, 0);

        for (String sb : set) {
            pw.println(sb);
        }

        br.close();
        pw.close();
    }

    public static void nm(int[] arr, int cnt, int start) {
        if (cnt == M) {
            String s = "";
            for (int i : ans) {
                s += i;
                s += " ";
            }
            set.add(s);
            cnt = 0;
            return;
        }
        for (int i = start; i < N; i++) {
            ans[cnt] = arr[i];
            nm(arr, cnt + 1, i);
        }
    }
}
