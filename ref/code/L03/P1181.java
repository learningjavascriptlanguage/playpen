import java.io.*;
import java.util.*;

public class P1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		
		int n, m;
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		
		int[] a = new int[n];
		tk = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(tk.nextToken());
		}
		
		int ans = 1, sum = 0; // 一开始就有一段
		for(int i=0; i<n; i++) {
			if(sum+a[i] > m) {
				ans++;
				sum = a[i];  // caution, not sum = 0
			} else {
				sum += a[i];
			}
		}
		
		System.out.println(ans);
		in.close();
	}
}