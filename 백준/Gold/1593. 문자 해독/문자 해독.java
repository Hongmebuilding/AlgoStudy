import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g, s;
        String W, S;

        String[] input = br.readLine().split(" ");
        g = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        W = br.readLine();
        S = br.readLine();

        int count = countPermutations(g, s, W, S);
        System.out.println(count);

        br.close();
    }

    private static int countPermutations(int g, int s, String W, String S) {
        Map<Character, Integer> WMap = new HashMap<>();
        Map<Character, Integer> tempMap = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < g; i++) {
            char c = W.charAt(i);
            WMap.put(c, WMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s; i++) {
            char c = S.charAt(i);
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);

            if (i >= g) {
                char removedChar = S.charAt(i - g);
                if (tempMap.get(removedChar) == 1) {
                    tempMap.remove(removedChar);
                } else {
                    tempMap.put(removedChar, tempMap.get(removedChar) - 1);
                }
            }

            if (i >= g - 1 && tempMap.equals(WMap)) {
                cnt++;
            }
        }

        return cnt;
    }
}