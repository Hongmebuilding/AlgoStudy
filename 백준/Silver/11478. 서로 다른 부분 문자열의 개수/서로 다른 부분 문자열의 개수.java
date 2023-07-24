
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        PrintWriter pw = new PrintWriter(System.out);
        Set<String> out = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                out.add(
                        input.substring(i, j));
            }
        }

        pw.println(out.size());

        pw.flush();
        pw.close();
        br.close();
    }
}
