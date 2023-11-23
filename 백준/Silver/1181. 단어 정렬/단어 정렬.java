import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<String>> mapByLength = new TreeMap<>();

        while(n-- > 0){
            String word = br.readLine();
            int length = word.length();

            mapByLength.putIfAbsent(length, new TreeSet<>());
            mapByLength.get(length).add(word);
        }

        for (int length : mapByLength.keySet()) {
            TreeSet<String> words = mapByLength.get(length);
            for (String word : words) {
                pw.println(word);
            }
        }

        pw.close();
        br.close();
    }
}
