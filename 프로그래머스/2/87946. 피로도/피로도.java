class Solution {
    static int length, ans[];
    static boolean visit[];
    static int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        length = dungeons.length;
        visit = new boolean[length];
        ans = new int[length];
        // idx 경우의 수
        dfs(0, k, dungeons);
        answer = max;
        return answer;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        if (cnt == length) {
            // 던전 탐험 시작
            max = Math.max(adventure(ans.clone(), k, dungeons), max);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ans[cnt] = i;
                dfs(cnt + 1, k, dungeons);
                visit[i] = false;
            }
        }
    }
    
    public int adventure(int[] orders, int k, int[][] dungeons) {
        int max = 0;
        for (int i = 0; i < orders.length; i++) {
            int order = orders[i];
            if(k >= dungeons[order][0]) {
                k -= dungeons[order][1];
                max++;
            }
        }
        return max;
    }
}