package com.deltacoding.luogu;

import java.io.*;
import java.util.*;

public class P2661 {
	static int[] next;
	static int[] inDegree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		next = new int[n+1];
		inDegree = new int[n+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=n; i++) {
			next[i] = Integer.parseInt(st.nextToken());
			inDegree[next[i]]++;
		}

		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(inDegree[i]==0 && !visited[i]) {
				deleteNode(i);
			}
		}

		// 统计每个环的大小
		int answer = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				answer = Math.min(answer, circle(i));
			}
		}

		System.out.println(answer);
	}

	/**
	 * @param p 当前点
	 */
	static int circle(int p) {
		visited[p] = true;
	    int length = 1;
	    while(!visited[next[p]]) {
	    	visited[next[p]] = true;
	        p = next[p];
	        length++;
	    }
	    return length;
	}

	static void deleteNode(int i) {
		visited[i] = true;
		int v = next[i];
		inDegree[v]--;
		if(inDegree[v]==0 && !visited[v]) {
			deleteNode(v);
		}
	}
}
