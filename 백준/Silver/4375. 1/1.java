import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int num = 0;
            for (int i = 1; ; i++) {
                num = num * 10 + 1;
                num %= n;
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}

