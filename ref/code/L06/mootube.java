package com.deltacoding.usaco.s2017_2018.jan2018.silver;

import java.io.*;
import java.util.*;

public class mootube {
	static int n;
	static int q;
	static ArrayList<Edge>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];  // 邻接表 adjacent table
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 1; i < n; i++) { // n-1条边
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1; // 顶点编号修正
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			graph[x].add(new Edge(y, w)); // 双向加边
			graph[y].add(new Edge(x, w));
		}

		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken())-1; // 顶点编号修正

			out.println(bfs(k, v));
		}
		out.close();
	}

	static int bfs(int k, int v) {
		// BFS
		int ans = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		boolean[] visited = new boolean[n];
		visited[v] = true;
		while(!queue.isEmpty()) {
			int curr = queue.poll();

			for(Edge e : graph[curr]) {  // for each
				if(!visited[e.to] && e.w >= k) {
					queue.offer(e.to);
					visited[e.to] = true;
					ans++;
				}
			}
		}
		return ans;
	}

	static class Edge {
		int to, w;
		public Edge(int to, int w) {
			this.to=to;
			this.w=w;
		}
	}

}