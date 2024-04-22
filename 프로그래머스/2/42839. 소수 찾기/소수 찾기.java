import java.util.HashSet;
import java.util.Set;

class Solution {
    static int arr[], length;
    static Set<Integer> set = new HashSet<>();
    static boolean visited[];

    public int solution(String numbers) {
        int answer = 0;
        length = numbers.length();
        visited = new boolean[length];
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Character.getNumericValue(numbers.charAt(i));
        }

        dfs("", 0);

        Integer[] numList = set.toArray(new Integer[0]);
        for (int i = 0; i < numList.length; i++) {
            if (isPrime(numList[i])) {
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public void dfs(String s, int depth) {
        if (depth > length) {
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String res = s + arr[i];
                set.add(Integer.valueOf(res));
                dfs(res, depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
