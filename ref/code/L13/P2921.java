package com.deltacoding.lab;

import java.io.*;
import java.util.*;

public class P2921 {
	static int[] answers;
	static int[] next;
	static int[] inDegree; // 有几头牛指向第i个房间
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		next = new int[n + 1];
		inDegree = new int[n + 1];
		answers = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			next[i] = Integer.parseInt(in.readLine());
			inDegree[next[i]]++;
		}

		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0 && !visited[i]) {
				deleteNode(i);
			}
		}

		// 统计每个环的大小
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				cicle(i);
			}
		}

		// points outside of circle
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0 && answers[i] == 0) { // not in loops
				toCircle(i);
			}
		}

		// print answers
		for (int i = 1; i <= n; i++) {
			System.out.println(answers[i]);
		}
	}

	/**
	 * @param current
	 *            当前点
	 */
	static void cicle(int current) {

		ArrayList<Integer> inLoop = new ArrayList<>(); // 记录环上有几个点
		inLoop.add(current);
		visited[current] = true;
		while (!visited[next[current]]) {
			visited[next[current]] = true;
	        inLoop.add(next[current]);
	        current = next[current];
	    }

		int len = inLoop.size();
		for (int i : inLoop) {
			answers[i] = len;
		}
	}

	static void deleteNode(int i) {
		visited[i] = true;
		inDegree[next[i]]--;

		while (inDegree[next[i]] == 0) { // 用循环替代递归，避免Stack Overflow
			visited[next[i]] = true;

			i = next[i];
			inDegree[next[i]]--;
		}
	}

	static void toCircle(int i) {
		Stack<Integer> to = new Stack<>();

		while (answers[i] == 0) { // not in loop
			to.add(i);
			i = next[i];
		}

		while (!to.isEmpty()) {
			int x = to.pop();
			answers[x] = answers[next[x]] + 1;
		}
	}

}