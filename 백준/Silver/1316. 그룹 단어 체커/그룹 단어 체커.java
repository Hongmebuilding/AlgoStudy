
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static int N;
	static String[] arr;
	static int cnt = 0;
	
	static boolean isGroup(String str) {
		
		Map<Character, Integer> map = new HashMap<>();
		
		//단어 순회
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			//현재 글자가 없다면 추가 map에 추가 ㄱㄱ
			if(!map.containsKey(now)) { // 같은 글자 아니면
				map.put(now, i); // b : 0,a : 1,n : 2 banana의 새로운 글자만 할 의도
			}else {//같은 글자면
				//연속되었을까?
				if(map.get(now) != i-1) { // 현재 글자의 인덱스와 이전에 같은 글자가 나왔던 마지막 인덱스가 연속적이지 않을 때
					return false;
				}	
				map.put(now, i);//같은글자이고 현재 글자의 인덱스와 그전에 나왔던 인덱스가 연속적이면 map에 넣어주라
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			if(isGroup(arr[i])) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
