

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int num = Integer.parseInt(br.readLine());

        while (num-- > 0) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == input.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(i));
                }
            }
            if (stack.isEmpty()) answer++;
        }
        pw.println(answer);
        pw.close();
    }
}
