package com.deltacoding.usaco.s2015_2016.dec2015.silver;

import java.io.*;
import java.util.*;

public class lightson_dfs {
	static boolean[][] lit;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static ArrayList<Point>[][] rooms;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new FileReader("lightson.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rooms = new ArrayList[n][n];
		lit = new boolean[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rooms[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			rooms[a][b].add(new Point(c, d));
		}

		lit[0][0] = true;
		// start by searching the top-left corner
		dfs(0, 0);
		int answer = 0;
		for (boolean[] row : lit) {
			for (boolean col : row) {
				if (col) {
					answer++;
				}
			}
		}
		System.out.println(answer);
//		out.println(answer);
//		out.close();
	}

	public static void dfs(int x, int y) {
		// if we've already searched this square, don't do it again to save time
		if (visited[x][y]) {
			return;
		}
			
		visited[x][y] = true;
		for (Point p : rooms[x][y]) {
			if (!lit[p.x][p.y]) {
				lit[p.x][p.y] = true;
				for (int i = 0; i < 4; i++) { // 查找之前漏走的房间
					int nx = p.x + dir[i][0]; // 注意p.x
					int ny = p.y + dir[i][1];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny]) {
						dfs(p.x, p.y); // 注意是p.x p.y
						break; // 只要执行一次就可以了
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && lit[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
