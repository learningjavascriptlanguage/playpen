package com.deltacoding.lab;

import java.util.*;
import java.io.*;

public class P3956 {
	static int[][] board; // board[i][j]存放该点原始颜色
	static int m;
	static boolean[][] visited; // 记录当前路径中已走过的点
	static int[][] dirArr = { // 方向数组
			{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] minCoin; // 记录到当前点的最小值
	static int answer = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(f.readLine());
		m = Integer.parseInt(tk.nextToken());
		int n = Integer.parseInt(tk.nextToken());
		board = new int[m][m];
		visited = new boolean[m][m];
		minCoin = new int[m][m];
		for (int i = 0; i < minCoin.length; i++) {
			Arrays.fill(minCoin[i], Integer.MAX_VALUE); // 对一维数组赋值
		}

		// 0: no color, 1: red, 2:yellow
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(f.readLine());
			int xCo = Integer.parseInt(tk.nextToken()) - 1; // 注意修正下标
			int yCo = Integer.parseInt(tk.nextToken()) - 1;
			int color = Integer.parseInt(tk.nextToken());
			board[xCo][yCo] = color + 1; // 对输入的颜色值做处理，默认的0表示透明
		}

		visited[0][0] = true;
		dfs(0, 0, 0, board[0][0]);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void dfs(int x, int y, int currentCoins, int currentColor) {
		if (currentCoins >= minCoin[x][y]) { // 最优性剪枝
			return;
		}
		minCoin[x][y] = currentCoins; // 更新搜索位置的最小花费

		if (x == m - 1 && y == m - 1) // 搜索结束条件
		{
			answer = Math.min(answer, currentCoins);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 计算下一步的位置
			int newX = x + dirArr[i][0];
			int newY = y + dirArr[i][1];
			if (newX >= m || newY >= m || newX < 0 || newY < 0) { // 越界
				continue;
			}
			
			if (visited[newX][newY]) {// 已走过
				continue;
			}
			
			if (board[x][y] == 0 && board[newX][newY] == 0) { // 连续两个都是透明色
				continue;
			}

			visited[newX][newY] = true;
			if (board[newX][newY] != 0) // 新位置有顏色
			{
				if (currentColor == board[newX][newY]) {
					dfs(newX, newY, currentCoins, board[newX][newY]);
				} else {
					dfs(newX, newY, currentCoins + 1, board[newX][newY]);
				}
			} else {
				dfs(newX, newY, currentCoins + 2, currentColor);
			}
			visited[newX][newY] = false;
		}
	}

}