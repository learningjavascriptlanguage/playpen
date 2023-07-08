import java.io.*;
import java.util.*;

public class P1996 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);  // q.offer() Ìí¼Ó   q.peek() ²é¿´  q.poll() É¾³ý
		}

		while(!q.isEmpty()) {
			
			for(int i=0; i<m-1; i++) {
				int num = q.poll();
				q.offer(num);
			}
			System.out.print(q.poll() + " ");
		}
	}
}