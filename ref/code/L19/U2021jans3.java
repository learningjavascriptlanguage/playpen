package com.deltacoding.usaco.s2020_2021.jan2021.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class U2021jans3 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] a = new int[1001][1001];
	    int N = Integer.parseInt(in.readLine());
	    for (int i = 1; i <= N; i++) {
	    	StringTokenizer st = new StringTokenizer(in.readLine());
	        for (int j = 1; j <= N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
	    }

		int colcnt = 0, rowcnt = 0;
	    for (int i = 1; i <= N; i++) {
	        int odd = 0, even = 0;
	        for (int j = 1; j <= N; j++) {
				if(j % 2 == 1) {
					odd += a[i][j];
				} else {
					even += a[i][j];
				}
			}
	        colcnt += Math.max(odd, even);

	        odd = 0;
	        even = 0;
	        for (int j = 1; j <= N; j++) {
	        	if(j % 2 == 1) {
					odd += a[j][i];
				} else {
					even += a[j][i];
				}
			}
	        rowcnt += Math.max(odd, even);
	    }
        System.out.println(Math.max(colcnt, rowcnt));
	}
}
