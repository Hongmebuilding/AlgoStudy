class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int maxCommon = 0;
        
        answer[0] = numer1 * denom2 + numer2 * denom1;
        answer[1] = denom1 * denom2;
        
        int range = answer[0] > answer[1] ? answer[0] : answer[1];
        
        for (int i = 1; i <= range; i++) {
            if(answer[0]%i==0 && answer[1]%i==0){
                maxCommon = i;
            }
        }
        
        answer[0] = answer[0]/maxCommon;
        answer[1] = answer[1]/maxCommon;
        
        return answer;
    }
}