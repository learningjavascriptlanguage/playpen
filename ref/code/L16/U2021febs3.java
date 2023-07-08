package com.deltacoding.usaco.s2020_2021.feb2021.silver;
import java.io.*;
import java.util.*;

public class U2021febs3 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[][] pasture = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				pasture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long ans = 0;
		int[] colmin = new int[n];
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int left = -1, cnt = 0;
				for(int k = 0; k < n; k++) {
					if (i == j) {
						colmin[k] = pasture[j][k];
					} else {
						colmin[k] = Math.min(colmin[k], pasture[j][k]);
					}
					
					if(colmin[k] < 100) {
						left = k;
						cnt = 0;
					}
					
					if(colmin[k] == 100) {
						cnt = k - left;
					}
					
					ans += cnt;
				}
			}
		}
		
		System.out.println(ans);
	}

}
