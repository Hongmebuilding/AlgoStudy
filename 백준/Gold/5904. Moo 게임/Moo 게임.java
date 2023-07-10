import java.util.Scanner;

public class Main {
    static char[] s1 = {'m', 'o', 'o'};

    public static void sol(int n, int k, int len){
        int new_len = len * 2 + k + 3;
        if(n <= 3){
            System.out.println(s1[n - 1]);
            return;
        }
        if(new_len < n){
            sol(n, k + 1, new_len);
        }
        else{
            if(n > len && n <= len + k + 3){
                if(n - len != 1)
                    System.out.println('o');
                else
                    System.out.println('m');
            }
            else{
                sol(n - (len + k + 3), 1, 3);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sol(n, 1, 3);
    }
}
