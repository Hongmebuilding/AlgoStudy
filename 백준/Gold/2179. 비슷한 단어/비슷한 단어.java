
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
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            list.add(word);
        }

        int a = 0;
        int b = 0;
        int max = 0;

        for (int i = 0; i < N-1; i++) {
            String front = list.get(i);
            for (int j = i+1; j < N; j++) {
                String back = list.get(j);
                int cnt = 0;
                int length = front.length() < back.length() ? front.length() : back.length();
                for (int k = 0; k < length; k++) {
                    if(front.charAt(k) != back.charAt(k)){
                        break;
                    }
                    cnt++;
                }
                if(max < cnt){
                    max = cnt;
                    a = i;
                    b = j;
                }
            }
        }

        pw.println(list.get(a));
        pw.println(list.get(b));

        pw.close();
        br.close();
    }
}
