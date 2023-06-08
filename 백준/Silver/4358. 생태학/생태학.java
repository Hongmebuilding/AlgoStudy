
import java.util.*;

public class Main {

	private static List<String> names = new ArrayList<>(); 
	private static Set<String> arrSet = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String name = sc.nextLine();
			if(name.isEmpty()) {
				break;
			}
			names.add(name);
		}
		sc.close();
			
		avg();
		
	}
	
	private static void avg(){
		// 중복 x, 정렬 된 list 
		arrSet.addAll(names);
	    List<String> sortedList = new ArrayList<>(arrSet);
        Collections.sort(sortedList);
        
        // 중복 횟수를 기록할 Map 생성
        Map<String, Double> avgMap = new HashMap<>();
        
        for(String name : names) {
        	if(avgMap.containsKey(name)) {
        		avgMap.put(name, avgMap.get(name) + (1.0 / names.size()));
        	} else {
        		avgMap.put(name, 1.0 / names.size());
        	}
        }
        
        for(String name : sortedList) {
        	double avg = avgMap.get(name);
        	System.out.printf("%s %.4f%n", name, avg*100);
        }
	}

}
