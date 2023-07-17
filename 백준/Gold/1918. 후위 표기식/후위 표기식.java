
import java.io.*;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        java.util.Stack<Character> stack = new Stack<>(); // 연산자 관리
        String input = br.readLine();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') { // 스택의 top에 여는 괄호가 나올 때까지 스택에서 pop하여 결과 문자열에 추가
                while(!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                if (!stack.isEmpty() && stack.peek() != '(')
                    System.out.println("Invalid Expression");
                else // 스택에서 여는 괄호를 pop
                    stack.pop();
            } else { // ()외 연산자
                // 스택이 비어있지 않고, 현재 연산자의 우선 순위가 스택의 top 연산자의 우선 순위보다 낮거나 같을 동안, 스택에서 pop하여 결과 문자열에 추가
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek()))
                    result += stack.pop();
                stack.push(c); // 현재 연산자를 스택에 푸시
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();

        pw.println(result);

        pw.close();
    }

    public static int priority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
