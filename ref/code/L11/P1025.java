package com.deltacoding.luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1025 {
	
	static int[] a;
	static int answer;
	static int n, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
		n =  Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[k + 1];
	    a[0] = 1;
	    dfs(1, n);
	    System.out.println(answer);        
	}
	
	static void dfs(int pos, int leftNum) {
		if(leftNum==0) {
			return;
		}
		if(pos == k) {
			if(leftNum >= a[pos-1]) {
				answer++;
			}
			return;
		}

		for(int i=a[pos-1]; i<=leftNum/(k-pos+1); i++) {
			a[pos] = i;
			dfs(pos+1, leftNum - i);
		}

	}
	
}
