package com.deltacoding.usaco.s2020_2021.feb2021.silver;
import java.io.*;
import java.util.*;

public class U2021febs1_DFS {
	static int pasture[][] = new int[3500][3500];
	static int[][] cnt = new int[3500][3500]; // cnt[i][j] (i, j)四周有几头牛
	static int ans = 0;
	static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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
		dfs(x, y);
		
		for(int i=0; i<4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];
			cnt[nx][ny]++;
			if(pasture[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}

	static void dfs(int x, int y) {
        if(cnt[x][y] != 3) {
        	return;
        }
		for(int i=0; i<4; i++) {
			int nx = x + DIR[i][0];
			int ny = y + DIR[i][1];
			if(pasture[nx][ny] == 0) {
				ans++;
				add(nx, ny);
				break;
			}
		}
	}

}
