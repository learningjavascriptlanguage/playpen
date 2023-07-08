import java.io.*;
import java.util.*;

public class P1190_PriorityQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
        
        tk = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	pq.offer(Integer.parseInt(tk.nextToken()));
        }
        
        for(int i=m; i<n; i++) {
        	int w = Integer.parseInt(tk.nextToken());
            pq.offer(pq.poll() + w);
        }

        for(int i=0; i<m-1; i++) {
        	pq.poll();
        }

        System.out.println(pq.poll());
	}
}