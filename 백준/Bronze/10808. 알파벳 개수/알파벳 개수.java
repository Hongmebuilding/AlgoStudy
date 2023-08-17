
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            pw.print(count[i] + " ");
        }

        br.close();
        pw.close();
    }
}