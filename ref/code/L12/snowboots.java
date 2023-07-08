package com.deltacoding.usaco.s2017_2018.feb2018.silver;

import java.io.*;
import java.util.*;

public class snowboots {
	static int N, B;
	static int[] f;
	static int[] s;
	static int[] d;
	static int answer = Integer.MAX_VALUE;
	static boolean[][] visited; // set of (location, boot) states we can reach

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new FileReader("snowboots.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		f = new int[N];
		s = new int[B];
		d = new int[B];
		visited = new boolean[N][B];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			f[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(in.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		System.out.println(answer);
//      in.close();
//		out.close();
	}

	static void dfs(int tileId, int bootId) {// 第i个tile, 目前穿着第b双靴子T
		if (visited[tileId][bootId]) {
			return;
		}

		visited[tileId][bootId] = true;

		if(bootId > answer) {
			return;
		}
		if (tileId == N - 1) {
			answer = Math.min(answer, bootId);
			return;
		}

		// try all possible steps forward
		for (int i = 1; i <= d[bootId]; i++) {
			if (tileId + i < N && f[tileId + i] <= s[bootId]) {
				dfs(tileId + i, bootId);
			}
		}

		// try all possible changes of boots
		for (int i = bootId + 1; i < B; i++) {
			if (f[tileId] <= s[i]) {
				dfs(tileId, i);
			}
		}
	}
}
