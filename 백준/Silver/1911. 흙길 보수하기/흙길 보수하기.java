import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static int cnt = 0;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //웅덩이 갯수
        int L = Integer.parseInt(st.nextToken()); //널빤지 길이
        TreeSet<Integer> start = new TreeSet<>();
        TreeSet<Integer> end = new TreeSet<>();

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); //웅덩이 시작 위치
            int E = Integer.parseInt(st.nextToken()); //웅덩이 끝 위치
            start.add(S);
            end.add(E);
        }

        while(!start.isEmpty() && !end.isEmpty()){
            int S = start.pollFirst();
            int E = end.pollFirst();
            result = S > result ? S : result;
            while(true){
                if(result < E){
                    result += L;
                    cnt++;
                }else {
                    break;
                }
            }
        }

        pw.println(cnt);

        pw.close();
        br.close();
    }
}
