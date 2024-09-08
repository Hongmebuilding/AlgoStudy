import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int wordsNumber = words.length;
        HashSet<String> note = new HashSet<>();
        
        // 초기 세팅
        String theFirstWord = words[0];
        char endOfTargetWord = theFirstWord.charAt(theFirstWord.length() - 1);
        String targetWord;
        note.add(theFirstWord);
        for(int i=1; i<wordsNumber; i++) {
            targetWord = words[i];
            if(note.contains(targetWord) || targetWord.charAt(0) != endOfTargetWord) {
                System.out.println(i);
            int number = i + 1;
            int who = number % n;
            answer[0] = who == 0 ? n : who;
            int turnNumber = number / n;
            answer[1] = who > 0 ? turnNumber + 1 : turnNumber;
            return answer;
            } else {
                note.add(targetWord);
                endOfTargetWord = targetWord.charAt(targetWord.length() - 1);
            }
        }
        return answer;
    }
    // for 문을 돌면서 hashmap -> 갯수 갯수 2이상 멈춰 return + 끝 단어 check 
    // hashmap key 단어 value 갯수, 
    // 틀린 단어 위치 -> i
    // 1. 누가 말했지 -> 위치만 알면 %로 구할 수 있다.
    // 2. 차례는 n/x+ (나누기 몫가 0이면 결과판에서 틀림, 0보다 크면 몫+1임)
}