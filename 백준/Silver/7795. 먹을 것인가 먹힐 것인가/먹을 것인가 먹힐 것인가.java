import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int [] listA = new int[A];
            int [] listB = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A; j++) {
                listA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B; j++) {
                listB[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(listA);
            Arrays.sort(listB);

            int idxA = listA.length - 1;
            int idxB = listB.length - 1;

            int cnt = 0;
            //1 1 3 7 8
            //1 3 6
            while(idxB >= 0 && idxA >= 0){
                int currentA = listA[idxA];
                int currentB = listB[idxB];

                if(currentA > currentB){
                    cnt += idxB + 1;
                    idxA--;
                } else {
                    idxB--;
                }
            }
            pw.println(cnt);
        }
        br.close();
        pw.close();
    }
}
