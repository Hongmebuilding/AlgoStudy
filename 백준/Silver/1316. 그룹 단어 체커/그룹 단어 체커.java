

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            boolean isGroup = true;

            for (int j = 0; j < s.length()-1; j++) {
                char currentChar = s.charAt(j);
                char nextChar = s.charAt(j+1);
                if(currentChar != nextChar && s.substring(j+1).contains(String.valueOf(currentChar))){
                    isGroup=false;
                    break;
                }
            }

            if(isGroup){
                total++;
            }


        }

        pw.println(total);

        pw.close();
        br.close();
    }
}
