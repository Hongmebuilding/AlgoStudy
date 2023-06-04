import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
        int[] answer = {};
        int[] blister1 = new int[answers.length]; // 수포자1 답안
        int[] blister2 = new int[answers.length]; // 수포자1 답안
        int[] blister3 = new int[answers.length]; // 수포자1 답안
        Map<Integer, Integer> blisters = new HashMap<>(); // 수포자가 맞은 갯수 기록
        int cnt = 1;
        int firstCnt = 0, secondCnt = 0, thirdCnt = 0;
        
        //1번 수포자
        for (int i = 0; i < answers.length; i++) {
            blister1[i] = cnt % 5 == 0 ? 5 : cnt % 5; // 0일 경우에 5로 바꾸어 주어야 합니다.
            cnt++;
        }
        //2번 수포자
        int[] pattern = {1, 3, 4, 5};
        for (int i = 0; i < answers.length; i++) {
        	if(i % 2 == 0) {
        		blister2[i] = 2;
        	}else {
        		blister2[i] = pattern[(i/2) % 4];
        	}
		}
        //3번 수포자
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            blister3[i] = pattern3[i % 10];
        }
        
        //채점
        for (int i = 0; i <answers.length; i++) {
			if(answers[i] == blister1[i]) {
				firstCnt++;
			}
			if(answers[i] == blister2[i]) {
				secondCnt++;
			}
			if(answers[i] == blister3[i]) {
				thirdCnt++;
			}
		}
        
        //수포자들의 이름과 결과를 정리한다
        blisters.put(1, firstCnt);
        blisters.put(2, secondCnt);
        blisters.put(3, thirdCnt);
        
        // 최대값 찾기
        int max = Collections.max(blisters.values());
        
        // 공동 1등 선출
        List<Integer> first = new ArrayList<>();
        // getKey() 메서드는 Map.Entry 인터페이스의 메서드이다
        // entrySet()의 반환객체는 Set 인터페이스를 구현한 컬렉션이다
        for(Map.Entry<Integer, Integer> entry: blisters.entrySet()) {
        	if(entry.getValue() == max) {
        		first.add(entry.getKey());
        	}
        }
        
        answer = new int[first.size()];
        for (int i = 0; i < first.size(); i++) {
			answer[i] = first.get(i);
		}
        
        return answer;
    }
}