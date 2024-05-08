import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int deployTime = (100 - progress) % speed != 0 ? (100 - progress) / speed + 1 : (100 - progress) / speed ;
            q.add(deployTime);            
        }
        while(!q.isEmpty()) {
            int prev = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && prev >= q.peek()) {
                cnt++; 
                q.poll();
            }
            list.add(cnt);
        }
    
        int len = list.size();
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}