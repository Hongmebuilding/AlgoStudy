
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(name);
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()){
            int age = entry.getKey();
            ArrayList<String> names = entry.getValue();
            for(String name : names){
                pw.println(age + " " + name);
            }
        }

        pw.close();
        br.close();
    }
}
