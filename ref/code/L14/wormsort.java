package com.deltacoding.usaco.s2019_2020.jan2020.silver;
import java.io.*;
import java.util.*;

public class wormsort {
	
	static int n, m;
	static Edge[] p;
	static int[] f;
	static int[] dest;
	
	static class Edge {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("wormsort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		f = new int[n + 1];
		dest = new int[n + 1];
		st = new StringTokenizer(in.readLine());
		boolean isSorted = true;
		for(int i=1; i<=n; i++) {
			dest[i] = Integer.parseInt(st.nextToken());
			if(dest[i] != i) {
				isSorted = false;
			}
		}
		// 特判  如果奶牛们不需要用任何虫洞来排序，输出 -1
	    if(isSorted) {
	    	out.println(-1);
	    	in.close();
	    	out.close();
	    	return;
		} 

		p = new Edge[m + 1];
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			p[i] =  new Edge(u, v, w);
		}
		Arrays.sort(p, 1, m+1, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});

	    int left=1, right=m, answer=0;
	    while(left<=right) {
	    	int mid = (left+right)/2;
	    	if(check(mid)) {
	    		answer=p[mid].w;
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
	    out.println(answer);
	    in.close();
		out.close();
	}
	
	static int find(int x)
	{
		if(f[x] == x) {
			return x;
		}
		f[x] = find(f[x]);
		return  f[x];
	}
	
	static void merge(int u, int v)
	{
		int fu = find(u);
		int fv = find(v);
		if(fu != fv) {
			f[fu] = fv;
		}
	}

	static boolean check(int mid) {
		for (int i = 1; i <= n; i++)
			f[i] = i;

		for (int i = mid; i <= m; i++)
			merge(p[i].u, p[i].v);

		for (int i = 1; i <= n; i++) {
			if (find(i) != find(dest[i]))
				return false;
		}
		return true;
	}
}