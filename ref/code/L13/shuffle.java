package com.deltacoding.usaco.s2017_2018.dec2017.silver;
import java.io.*;
import java.util.*;
public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int n = Integer.parseInt(in.readLine());
		int[] shuffle = new int[n];
		int[] inDegree = new int[n]; // 记录i位置共有几个来源
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			shuffle[i] = Integer.parseInt(st.nextToken())-1;
			inDegree[shuffle[i]]++;
		}
		int answer = n;
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
				answer--;
			}
		}
		while(!q.isEmpty()) {
			int curr = shuffle[q.poll()];
			inDegree[curr]--;
			if(inDegree[curr] == 0) {
				q.offer(curr);
				answer--;
			}
		}
		out.println(answer);
		out.close();
	}
}
