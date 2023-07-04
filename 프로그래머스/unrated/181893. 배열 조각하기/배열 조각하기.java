import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int front = 0;
        int back = arr.length;

        for(int i = 0; i < query.length; i++){
            if(i % 2 == 0){ 
                back = front + query[i] + 1;
            } else { 
                front = front + query[i];
            }
        }

        int[] answer = Arrays.copyOfRange(arr, front, back);
        return answer;
    }
}
