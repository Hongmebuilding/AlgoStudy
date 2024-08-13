import java.io.*;
import java.util.*;
class Solution {
    static boolean[] visited;
    static int n, computers[][], map[][];
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        //map 만듦
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i==j) continue;
                if(computers[i][j] == 1) {
                    map[i][j] = 1;
                }
            }
        }
        int answer = findNetCnt();     
        
        return answer;
    }
    public static int findNetCnt() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                cnt += dfs(i);
            }
        }
        return cnt;
    }
    
    //연결되있는데로 count visited 표시하면서
    //visited 안되있으면 그 지점부터 시작
    public static int dfs(int start) {
        visited[start] = true;
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            if(map[start][i]==1 && !visited[i]){
                dfs(i);
            }
        }
        return cnt;
    }
}