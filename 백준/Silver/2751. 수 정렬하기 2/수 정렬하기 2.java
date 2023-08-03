import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        TreeSet<Integer> set = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            set.add(Integer.valueOf(br.readLine()));
        }

        for (int i : set){
            pw.println(i);
        }
        pw.close();
        br.close();
    }
}
