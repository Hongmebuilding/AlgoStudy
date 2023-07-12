
import java.io.*;
import java.util.*;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        Deque deque = new LinkedList<>();

        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push_back":
                    int num = Integer.parseInt(st.nextToken());
                    deque.offerLast(num);
                    break;
                case "push_front":
                    int num1 = Integer.parseInt(st.nextToken());
                    deque.offerFirst(num1);
                    break;
                case "pop_front":
                    pw.println(deque.isEmpty() ? "-1" : deque.pollFirst());
                    break;
                case "pop_back":
                    pw.println(deque.isEmpty() ? "-1" : deque.pollLast());
                    break;
                case "size":
                    pw.println(deque.size());
                    break;
                case "empty":
                    pw.println(deque.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    pw.println(deque.isEmpty() ? "-1" : deque.peekFirst());
                    break;
                case "back":
                    pw.println(deque.isEmpty() ? "-1" : deque.peekLast());
                    break;
            }
        }
        pw.close();
    }
}
