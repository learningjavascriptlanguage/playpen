package com.deltacoding.usaco.s2020_2021.feb2021.silver;
import java.io.*;
import java.util.*;

public class U2021febs1_BFS {
	static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int pasture[][] = new int[3500][3500];
	static int ans = 0;
	static Queue<point> q = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x += 1000;
			y += 1000;
			if (pasture[x][y] > 0) {
				ans--;
			} else {
				add(x, y);
			}
			System.out.println(ans);
		}
	}

	static void add(int x, int y) {
		pasture[x][y] = 1;
		check(x, y);
	
		while (!q.isEmpty()) {
			point p = q.poll();
			int u = p.x, v = p.y;
			if (!comfortable(u, v)) {
				continue;
			}
			for(int i=0; i<4; i++) {
				int nu = u + DIR[i][0];
				int nv = v + DIR[i][1];
				if(pasture[nu][nv] == 0) {
					ans++;
					pasture[nu][nv] = 1;
					check(nu, nv);
					break;
				}
			}
		}

	}

	static void check(int x, int y) {
		if (comfortable(x, y)) {
			q.offer(new point(x, y));
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];
			if (comfortable(nx, ny)) {
				q.offer(new point(nx, ny));
			}
		}
	}
	
	static boolean comfortable(int x, int y) {
		if(pasture[x][y] == 0) {
			return false;
		}
		
		int adjacent = 0;
		for(int i=0; i<4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];
			adjacent += pasture[nx][ny];
		}
		return adjacent == 3;
	}

}
