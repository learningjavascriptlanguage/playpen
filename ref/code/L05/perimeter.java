package com.deltacoding.usaco.s2018_2019.jan2019.silver;

import java.io.*;
import java.util.*;

public class perimeter {
	static int n, maxArea=0, perimeter=Integer.MAX_VALUE; // 结果
	static boolean[][] icy;
	static boolean[][] vis;
	static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		n = Integer.parseInt(in.readLine());
		icy = new boolean[n][n];
		vis = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String s = in.readLine();
			for(int j=0; j<s.length(); j++) {
				icy[i][j] = (s.charAt(j) == '#');
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(icy[i][j] && !vis[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		out.println(maxArea + " " + perimeter);
		in.close();
		out.close();
	}

	static void bfs(int i, int j) {
		Queue<Point> q = new ArrayDeque<>();
		int blobArea=1, blobPerimeter=0; // 面积 周长
		q.offer(new Point(i, j));
		vis[i][j] = true;
		while(!q.isEmpty()) {
			Point point = q.poll();
			for(int k=0; k<4; k++) {
				int nx = point.x + DIR[k][0];
				int ny = point.y + DIR[k][1];
				if(nx<0 || nx>=n || ny<0 || ny>=n || !icy[nx][ny]) {
					blobPerimeter++;
					continue;
				}
				if(vis[nx][ny]) {
					continue;
				}
				q.offer(new Point(nx, ny));
				vis[nx][ny] = true;
				blobArea++;
			}
		}

		if(blobArea > maxArea) {
			maxArea = blobArea;
			perimeter = blobPerimeter;
		} else if (blobArea == maxArea) {
			perimeter = Math.min(blobPerimeter, perimeter);
		}
	}
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}