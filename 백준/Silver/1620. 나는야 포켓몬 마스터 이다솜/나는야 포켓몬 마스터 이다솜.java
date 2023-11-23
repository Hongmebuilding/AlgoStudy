
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> poketmonBynumber = new HashMap<>();
        Map<String, Integer> poketmonByname = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            poketmonBynumber.put(i+1, name);
            poketmonByname.put(name, i+1);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (48 <= input.charAt(0) && input.charAt(0) <= 57){
                pw.println(poketmonBynumber.get(Integer.parseInt(input)));
            }else {
                pw.println(poketmonByname.get(input));
            }
        }

        pw.flush();
        pw.close();
        br.close();
    }
}
