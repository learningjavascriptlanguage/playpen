
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1031 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] data = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}
		int avg = sum / n;
		for(int i=0; i<n; i++) {
			data[i] -= avg;
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(data[i] == 0) {
				continue;
			}
			data[i+1] += data[i];
			cnt++;
		}
		System.out.println(cnt);
	}
}
