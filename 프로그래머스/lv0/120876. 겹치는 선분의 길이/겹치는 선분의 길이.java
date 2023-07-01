import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] lines) {

        PrintWriter pw = new PrintWriter(System.out);
        int answer = 0;
        List<Integer> segmentst = new ArrayList<>();
        List<Integer> segmentnd = new ArrayList<>();
        List<Integer> segmentrd = new ArrayList<>();

        for(int i = 0, num = lines[0][0]; i<lines[0][1]-lines[0][0];i++){
            segmentst.add(num);
            num++;
        }

        for(int i = 0, num = lines[1][0]; i<lines[1][1]-lines[1][0];i++){
            segmentnd.add(num);
            num++;
        }

        for(int i = 0, num = lines[2][0]; i<lines[2][1]-lines[2][0];i++){
            segmentrd.add(num);
            num++;
        }

        for(int i = 0; i<segmentst.size();i++){
            if(segmentnd.contains(segmentst.get(i))){
                answer++;
                segmentnd.remove(segmentst.get(i));

            } else if(segmentrd.contains(segmentst.get(i))){
                answer++;
                segmentrd.remove(segmentst.get(i));
            }
        }

        for(int i = 0; i<segmentnd.size();i++){
            if(segmentrd.contains(segmentnd.get(i))){
                answer++;
                segmentrd.remove(segmentnd.get(i));
            }
        }

        pw.close();


        return answer;
    }
}