import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibo {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		System.out.println(fibo(n));
	}
	
	static int fibo(int n) {
		if(n<3) {
			return 1;
		}

		return fibo(n-1) + fibo(n-2);
	}

}
