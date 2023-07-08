package com.deltacoding.usaco.s2020_2021.usopen2021.silver;
import java.io.*;
import java.util.*;

public class U2021usopens1 {
	static final int ThreePower9 = 19683;
	static int[] pow3 = new int[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
		int N, sx = 0, sy = 0;
		int[][] a = new int[25][25];
		boolean[] winning = new boolean[ThreePower9];
		boolean[] visited = new boolean[ThreePower9 * 625];
		boolean[] found = new boolean[ThreePower9];
		int ans = 0;

		N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			char[] s = str.toCharArray();
			for (int j = 0; j < N; j++) {
				if (s[j * 3] == '#') {
					a[i][j] = -2;
				}

				if (s[j * 3] == 'B') {
					sx = i;
					sy = j;
					a[i][j] = -1;
				}

				if (s[j * 3] == '.') {
					a[i][j] = -1;
				}

				if (s[j * 3] == 'O') {
					a[i][j] = (s[j * 3 + 1] - '1') * 3 + (s[j * 3 + 2] - '1');
				}

				if (s[j * 3] == 'M') {
					a[i][j] = 9 + (s[j * 3 + 1] - '1') * 3 + (s[j * 3 + 2] - '1');
				}
			}
		}

		pow3[0] = 1; // 3^0 ~ 3^9
		for (int i = 1; i <= 9; i++) {
			pow3[i] = pow3[i - 1] * 3;
		}

		// 预处理出， 3*3的⽹格的状态中，哪些是赢的状态
		for (int i = 0; i < pow3[9]; i++) {
			winning[i] = getWinState(i);
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.offer((sx * N + sy) * pow3[9]);
		visited[q.peek()] = true;
		while (!q.isEmpty()) {
			int u = q.poll();
			if (winning[u % pow3[9]]) {
				found[u % pow3[9]] = true;
				continue;
			}
			int x = u / pow3[9] / N;
			int y = u / pow3[9] % N;
			int us = u % pow3[9];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if (a[nx][ny] == -2) {
					continue;
				}
				int vs = move(us, a[nx][ny]);
				int v = (nx * N + ny) * pow3[9] + vs;
				if (!visited[v]) {
					q.offer(v);
					visited[v] = true;
				}
			}
		}
		for (int i = 0; i < pow3[9]; i++) {
			if (found[i])
				ans++;
		}
		System.out.println(ans);
	}

	static boolean getWinState(int i) {
		return (bit(i, 0) == 2 && bit(i, 1) == 1 && bit(i, 2) == 1)
				|| (bit(i, 3) == 2 && bit(i, 4) == 1 && bit(i, 5) == 1)
				|| (bit(i, 6) == 2 && bit(i, 7) == 1 && bit(i, 8) == 1)
				|| (bit(i, 2) == 2 && bit(i, 1) == 1 && bit(i, 0) == 1)
				|| (bit(i, 5) == 2 && bit(i, 4) == 1 && bit(i, 3) == 1)
				|| (bit(i, 8) == 2 && bit(i, 7) == 1 && bit(i, 6) == 1)
				|| (bit(i, 0) == 2 && bit(i, 3) == 1 && bit(i, 6) == 1)
				|| (bit(i, 1) == 2 && bit(i, 4) == 1 && bit(i, 7) == 1)
				|| (bit(i, 2) == 2 && bit(i, 5) == 1 && bit(i, 8) == 1)
				|| (bit(i, 6) == 2 && bit(i, 3) == 1 && bit(i, 0) == 1)
				|| (bit(i, 7) == 2 && bit(i, 4) == 1 && bit(i, 1) == 1)
				|| (bit(i, 8) == 2 && bit(i, 5) == 1 && bit(i, 2) == 1)
				|| (bit(i, 0) == 2 && bit(i, 4) == 1 && bit(i, 8) == 1)
				|| (bit(i, 8) == 2 && bit(i, 4) == 1 && bit(i, 0) == 1)
				|| (bit(i, 2) == 2 && bit(i, 4) == 1 && bit(i, 6) == 1)
				|| (bit(i, 6) == 2 && bit(i, 4) == 1 && bit(i, 2) == 1);
	}

	static int bit(int stat, int pos) { // 井字棋中第pos个位置的值是多少
		return stat / pow3[pos] % 3;
	}

	static int move(int stat, int dest) {
		if (dest == -1 || bit(stat, dest % 9) > 0) { // 迷宫中为空地 或者 井字棋中该位置已有棋
			return stat;
		}
		return stat + (dest / 9 + 1) * pow3[dest % 9];
	}
}
