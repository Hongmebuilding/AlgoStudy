
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String str = "";
        StringBuilder sb = new StringBuilder();

        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(65<=ch && ch<=90 ){
                ch += 13;
                if(ch>90){
                    ch -= 26;
                }
            }
            if(97<=ch && ch<=122 ){
                ch += 13;
                if(ch>122){
                    ch -= 26;
                }
            }
            sb.append((char)ch);
        }

        pw.println(sb);

        pw.close();
        br.close();
    }
}