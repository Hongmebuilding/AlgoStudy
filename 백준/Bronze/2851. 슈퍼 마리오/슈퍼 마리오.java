import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int closestTo100 = 0;

        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            sum += score;

            if (Math.abs(sum - 100) <= Math.abs(closestTo100 - 100)) {
                closestTo100 = sum;
            } else {
                break;
            }
        }

        System.out.println(closestTo100);

        br.close();
    }
}
