import java.io.*;
import java.util.*;

public class P1540_queue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		tk = new StringTokenizer(in.readLine());
		int counter = 0;
		for(int i=0; i<n; i++) {
			int word = Integer.parseInt(tk.nextToken());
			if(q.contains(word)) {
				continue;
			}
			
			// add to queue
			if(q.size() == m) {
				q.poll();
			}
			q.offer(word);
			counter++;
		}
        
		System.out.println(counter);
	}
}