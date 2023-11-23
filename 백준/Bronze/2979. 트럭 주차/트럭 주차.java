
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())*1;
        int B = Integer.parseInt(st.nextToken())*2;
        int C = Integer.parseInt(st.nextToken())*3;
        char[] hour = new char[100];
        int total = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());

            for (int j = depart; j < arrive; j++) {
                if(hour[j] =='A'){
                    hour[j] = 'B';
                }
                else if(hour[j]=='B'){
                    hour[j]='C';
                }
                else {
                    hour[j] ='A';
                }
            }

        }

        for (char c : hour){
            if(c == 'A'){
                total += A;
            }
            else if(c == 'B'){
                total += B;
            }
            else if(c == 'C'){
                total += C;
            }
            else{
                continue;
            }
        }


        pw.println(total);

        pw.close();
        br.close();
    }
}
