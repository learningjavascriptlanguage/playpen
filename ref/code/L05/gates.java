package com.deltacoding.usaco.s2015_2016.jan2016.silver;

import java.io.*;
import java.util.*;

/*
可以通过范围裁剪进一步优化时间
 */
public class gates {
	// direction
	static final int[][] DIRECTION = { { -1, 0 },
			                           { 1, 0 },
			                           { 0, -1 },
			                           { 0, 1 } };
	static int n;
	static boolean[][] visited;
	// bounds
	static int top = Integer.MAX_VALUE, bottom = 0, left = Integer.MAX_VALUE, right = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("gates.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		String s = in.readLine();
		int currX = 2*n + 2;
		int currY = 2*n + 2;
		visited = new boolean[4*n+5][4*n+5];
		visited[currX][currY] = true;
		for (int i = 0; i < s.length(); i++) {
			int dirX = 0, dirY = 0; // 行和列的改变值
			if (s.charAt(i) == 'N') {
				dirX = -1;
			} else if (s.charAt(i) == 'S') {
				dirX = 1;
			} else if (s.charAt(i) == 'W') {
				dirY = -1;
			} else {
				dirY = 1;
			}
			for (int j = 0; j < 2; j++) {
				currX += dirX;
				currY += dirY;
				visited[currX][currY] = true;
			}
			
	        // 裁剪空白边框, 优化速度
			top = Math.min(top, currX);
			bottom = Math.max(bottom, currX);
			left = Math.min(left, currY);
			right = Math.max(right, currY);
		}

		top--;
		bottom++;
		left--;
		right++;

		int anwser = -1; // 门的个数为连通块数减1
		for (int i = top; i <=bottom; i++) {
			for (int j = left; j <= right; j++) {
				if (!visited[i][j]) {
					anwser++; // 发现新的连通块
					bfs(i, j);
				}
			}
		}
		out.println(anwser);
		in.close();
		out.close();
	}

	static void bfs(int i, int j) {
		Queue<Point> q = new ArrayDeque<Point>();
		q.offer(new Point(i, j));
		visited[i][j] = true;
		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = curr.x + DIRECTION[k][0];
				int ny = curr.y + DIRECTION[k][1];
				if (nx < top || nx > bottom || ny < left || ny > right) {
					continue;
				}
				if (visited[nx][ny]) {
					continue;
				}
				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
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