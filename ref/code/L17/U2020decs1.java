package com.deltacoding.usaco.s2020_2021.dec2020.silver;
import java.io.*;
import java.util.*;

public class U2020decs1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] degree = new int[n+1];
		for(int i=1; i< n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			degree[a]++;
			degree[b]++;
		}
		int answer = 0;
		degree[1]++;
		for(int i=1; i<=n; i++) {
			if(degree[i] > 1) { // not leaf
				answer += doubleCow(degree[i]);
			}
		}
		
		System.out.println(answer + n - 1);
	}
	
	static int doubleCow(int num) {
		int cnt = 0;
		while((1<<cnt) < num) {
			cnt++;
		}
		return cnt;
	}
}
