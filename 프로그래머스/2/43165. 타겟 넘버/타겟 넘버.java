import java.util.*;
import java.io.*;

class Solution {
    static String[] arr = {"-","+"};
    static int answer = 0;
    static int target;

    public int solution(int[] numbers, int target) {
        this.target = target;
        findTwoWay("", 0, numbers);
        return answer;
    }

    public void findTwoWay(String prefix, int m, int[] numbers) {
        if(m == numbers.length){
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                sum = calculate(prefix.charAt(i), numbers[i], sum);
            }
            if(sum == target) {
                answer++;
            }
            return;
        }
        findTwoWay(prefix + arr[0], m+1, numbers);
        findTwoWay(prefix + arr[1], m+1, numbers);
    }
    
    public int calculate(char operation, int number, int sum) {
        switch(operation){
            case '+': 
                return sum + number;
            case '-': 
                return sum - number;
            default:
                return sum;
        }
    }
}