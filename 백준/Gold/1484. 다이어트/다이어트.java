import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<Integer> list = new ArrayList<>(); // int 65000, long 21억
        int G = Integer.parseInt(br.readLine());
        int P = 1;
        int LIdx = 0;
        int RIdx = 0;
        int cnt = 0;

        while(G >= P*P - (P-1)*(P-1)){
            list.add(P*P);
            P++;
        }

        int max = list.size()-1;
        while(true){
            if(RIdx > max || LIdx < 0){ 
                break;
            }
            int P2 = (RIdx + 1)*(RIdx + 1);
            int R2 = (LIdx + 1)*(LIdx + 1);
            int res = P2 - R2;

            if(res > G){
                LIdx++;
            } else if (res < G) {
                RIdx++;
            } else if (res == G){
                pw.println((RIdx + 1));
                RIdx++;
                cnt ++;
            }
        }

        if(cnt == 0){
            pw.println(-1);
        }

        br.close();
        pw.close();
    }
}
