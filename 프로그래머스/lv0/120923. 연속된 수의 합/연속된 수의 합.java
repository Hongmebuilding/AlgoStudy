import java.util.*;
import java.io.*;
/*
 * 12/3=4
 * [4]
 * [0,4,0]
 * 왼쪽이면 -1 오른쪽이면 +1
 * [345]
 
 2 11
 56
 [5,0]
 */
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        answer[(num-1)/2] = total/num;//[0,4,0]
        int left = (num-1)/2-1; 
        int right = (num-1)/2+1; 
        
        if(num>2){ //왼쪽이 존재할때
            while(left != -1){
                answer[left] = answer[left+1]-1;
                left--;
            }
        }
        //오른쪽 채우기[3,4,0]
        while(right < num){
            answer[right] = answer[right-1]+1;
            right++;
        }
       
        return answer;
    }
}