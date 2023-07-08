import java.io.*;
import java.util.*;

public class P1056 {
	
    static class Road {
    	int id;  // 道路编号
    	int num; // 隔开的对数
    	
    	public Road(int id, int num) {
    		this.id = id;
    		this.num = num;
    	}
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
		// M,N,K,L,D
		int m = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());
		int k = Integer.parseInt(tk.nextToken());
		int L = Integer.parseInt(tk.nextToken());
		int d = Integer.parseInt(tk.nextToken());
		
		Road[] row = new Road[m+1];
		Road[] col = new Road[n+1];
		
		for(int i=1; i<=m; i++) {
			row[i] = new Road(i, 0);
		}
		
		for(int i=1; i<=n; i++) {
			col[i] = new Road(i, 0);
		}

		for(int i=0; i<d; i++) {
			int xi, yi, pi, qi;
			tk = new StringTokenizer(in.readLine());
			xi = Integer.parseInt(tk.nextToken());
			yi = Integer.parseInt(tk.nextToken());
			pi = Integer.parseInt(tk.nextToken());
			qi = Integer.parseInt(tk.nextToken());
			if(xi==pi) { // 在同一行
				int id = Math.min(yi, qi);
				col[id].num++;
			} else {   // 在同一列
				int id = Math.min(xi, pi);
				row[id].num++;
			}
		}
		
		// 隔开人数从大到小排序（贪心）
		// 对1~m 按照隔开人数从大到小排序
		Arrays.sort(row, 1, m+1, new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				return o2.num - o1.num;
			}
		});
		
		// 对1~n 按照隔开人数从大到小排序
		Arrays.sort(col, 1, n+1, new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				return o2.num - o1.num;
			}
		});
		
		// 对1~k 按照id从小到大排序
		Arrays.sort(row, 1, k+1, new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				return o1.id - o2.id;
			}
		});
		
		// 对1~L 按照id从小到大排序
		Arrays.sort(col, 1, L+1, new Comparator<Road>() {

			@Override
			public int compare(Road o1, Road o2) {
				return o1.id - o2.id;
			}
		});

		for(int i=1; i<=k; i++) {
			System.out.print(row[i].id+" ");
		}
        
		System.out.println();
		
		for(int i=1; i<=L; i++) {
			System.out.print(col[i].id+" ");
		}
	}
}