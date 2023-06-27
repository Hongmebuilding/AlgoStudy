
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		System.out.println(Fac(n));
		
	}
	
	public static int Fac(int n) {
		if(n<=1) {
			return 1;
		}
		else
			return Fac(n-1)*n;
	}
}
