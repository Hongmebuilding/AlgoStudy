
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String command;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Integer> map = new HashMap<>(); //문제 번호,난이도
    static TreeMap<Integer, TreeSet<Integer>> mapByDifficulty = new TreeMap<>(); // 난이도, 문제 번호들

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            map.put(P, L);
            mapByDifficulty.putIfAbsent(L, new TreeSet<>());
            mapByDifficulty.get(L).add(P);
        }

        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            doIt(command);
        }

        br.close();
    }

    private static void doIt(String command) throws IOException {
        switch (command) {
            case "add":
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                map.put(P, L);
                mapByDifficulty.putIfAbsent(L, new TreeSet<>());
                mapByDifficulty.get(L).add(P);
                break;
            case "recommend":
                int recommendationType = Integer.parseInt(st.nextToken());
                if(recommendationType == 1){
                    int hardest = mapByDifficulty.lastKey();
                    System.out.println(mapByDifficulty.get(hardest).last());
                }
                else if(recommendationType == -1){
                    int easiest = mapByDifficulty.firstKey();
                    System.out.println(mapByDifficulty.get(easiest).first());
                }
                break;
            case "solved":
                int solvedP = Integer.parseInt(st.nextToken());
                int solvedL = map.get(solvedP);
                map.remove(solvedP);
                mapByDifficulty.get(solvedL).remove(solvedP);
                if (mapByDifficulty.get(solvedL).isEmpty()) {
                    mapByDifficulty.remove(solvedL);
                }
                break;
        }
    }
}
