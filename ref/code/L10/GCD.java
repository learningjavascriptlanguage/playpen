import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(gcd(a, b));
	}
	
	static int gcd(int a, int b) {
		// 递归结束条件
		if(a % b == 0) {
			return b;
		}
		
		// 递归公式
		return gcd(b, a%b);
	}

}
