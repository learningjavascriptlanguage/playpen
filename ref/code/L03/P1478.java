import java.io.*;
import java.util.*;

public class P1478 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		
		// 苹果数n，力气s
		int n = Integer.parseInt(tk.nextToken());
		int s = Integer.parseInt(tk.nextToken());
		
		int[] apples = new int[n];
		int cnt = 0;
		
		// 总身高
		tk = new StringTokenizer(in.readLine());
		int h = Integer.parseInt(tk.nextToken()) + Integer.parseInt(tk.nextToken());
		
		for(int i=0; i<n; i++) {
			tk = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());
			if(x > h) {
				continue;
			}
			apples[cnt] = y;
			cnt++;			
		}
		
		// sort
		Arrays.sort(apples, 0, cnt); // ascending order
		
		int ans=0;
		for(int i=0; i<cnt; i++) {
			if(s>=apples[i]) {
				s-=apples[i];
				ans++;
			} else {
				break;
			}
		}
		
		System.out.println(ans);
	}
}