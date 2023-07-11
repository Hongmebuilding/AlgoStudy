
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();

        while(n-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        pw.println(q.poll());
                    }else {
                        pw.println("-1");
                    }
                    break;
                case "size":
                    pw.println(q.size());
                    break;
                case "empty":
                    pw.println(q.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    if(!q.isEmpty()){
                        pw.println(q.peekFirst());
                    }else {
                        pw.println("-1");
                    }
                    break;
                case "back":
                    if(!q.isEmpty()){
                        pw.println(q.peekLast());
                    }else {
                        pw.println("-1");
                    }
                    break;
            }

        }

        pw.close();
    }
}
