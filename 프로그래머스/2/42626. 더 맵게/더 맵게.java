import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int cnt = 0;
        int num1 = 0;
        int num2 = 0;
        int degree = 0;
        while(pq.size() >= 2 && pq.peek() < K){
            num1 = pq.poll();
            num2 = pq.poll();
            degree = num1 + (num2 * 2);
            cnt++;
            pq.add(degree);
        }
        if(pq.peek() < K) {
            return -1;
        }
        return cnt;
    }
}