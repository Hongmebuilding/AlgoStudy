
import java.util.*;
import java.io.*;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String in = br.readLine();
        int cnt = 0; // 제거 횟수
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int c = Character.getNumericValue(in.charAt(i));
            if(cnt < K){
                if (!deque.isEmpty()) {
                    if (deque.peekLast() < c) { // 덱이 현재보다 작을 때
                        while(deque.peekLast() < c && cnt < K){
                            deque.removeLast();
                            cnt++;
                            if(deque.isEmpty()){
                                break;
                            }
                        }
                        deque.addLast(c);
                    }
                    else if(deque.peekLast() == c){ // 덱이 현재보다 같을 때
                        deque.addLast(c);
                    }
                    else if(deque.peekLast() > c){ // 덱이 현재보다 클 때
                        deque.addLast(c);

                    }
                } else { // 비어있을때
                    deque.addLast(c);
                }

            }else {
                deque.addLast(c);
            }
        }

        // cnt가 0일때 == 4321,1111
        if(cnt!=K){
            for (int i = 0; i < N-K; i++) {
                pw.print(deque.removeFirst());
            }

        }else {
            for (int element : deque) {
                pw.print(element);
            }

        }
        pw.close();
    }
}
