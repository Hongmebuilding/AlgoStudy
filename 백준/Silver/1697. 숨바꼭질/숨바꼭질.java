import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int goal, cnt, N;
    static boolean visited[], flag;
    static Deque<Integer> q = new LinkedList<>();
    static Deque<Integer> cntQueue = new LinkedList<>(); // 각 노드의 층수를 저장하는 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        N = 200001;
        visited = new boolean[N];
        cnt = 0;

        bfs(start);
        System.out.println(cnt);
    }

    public static void bfs(int start) {
        if(start == goal){
            cnt = 0;
            return;
        }
        q.addFirst(start);
        cntQueue.addFirst(0);
        visited[start] = true;
        while (!q.isEmpty() && !flag) {
            start = q.pollFirst();
            int currentCnt = cntQueue.pollFirst();
            int rear = start - 1;
            int advance = start + 1;
            int jump = start * 2;
            if (rear == goal || advance == goal || jump == goal) {
                flag = true;
                cnt = currentCnt + 1;
                break;
            }
            // 각 노드와 그 노드의 층수를 큐에 추가
            if (rear >= 0 && !visited[rear]) {
                q.addLast(rear);
                cntQueue.addLast(currentCnt + 1);
                visited[rear] = true;
            }
            if (advance < N && !visited[advance]) {
                q.addLast(advance);
                cntQueue.addLast(currentCnt + 1);
                visited[advance] = true;
            }
            if (jump < N && !visited[jump]) {
                q.addLast(jump);
                cntQueue.addLast(currentCnt + 1);
                visited[jump] = true;
            }
        }
    }
}
