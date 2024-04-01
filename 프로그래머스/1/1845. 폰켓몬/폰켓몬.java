import java.util.*;
import java.io.*;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
    for(int n : nums) {
        set.add(n);
    }
        int allowNumber = nums.length / 2;
        if(set.size() > allowNumber) {
            answer = allowNumber;
        } else {
            answer = set.size();
        }
        return answer;
    }
}