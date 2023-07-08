package com.deltacoding.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1330 {
	static ArrayList<Integer>[] graph;
	static int[] colors;
	static boolean[] visited;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		colors = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= m; i++) {
			tk = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			graph[a].add(b); // 双向加边
			graph[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				if (!bfs(i)) {
					System.out.println("Impossible");
					return;
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean bfs(int begin) {

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(begin);
		int sum0 = 1, sum1 = 0; // 0和1的颜色点数
		colors[begin] = 0; // i点涂颜色0
		visited[begin] = true;

		while (!q.isEmpty()) {
			int from = q.poll();
			for (int to : graph[from]) {
				if (visited[to]) {
					if (colors[from] == colors[to]) // 颜色冲突
					{
						return false;
					}
				} else {
					q.offer(to);
					visited[to] = true;
					if (colors[from] == 0) {
						colors[to] = 1;
						sum1++;
					} else {
						colors[to] = 0;
						sum0++;
					}
				}
			}
		}

		ans += Math.min(sum0, sum1);
		return true;
	}
}
