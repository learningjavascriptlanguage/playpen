import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		System.out.println(factorial(n));

	}
	
	static int factorial(int n) {
		// 递归结束条件
		if(n==1) {
			return 1;
		}
		
		// 递归公式
		return n*factorial(n-1);
	}

}
