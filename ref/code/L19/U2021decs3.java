package com.deltacoding.usaco.s2021_2022.dec2021.silver;

import java.io.*;
import java.util.*;

public class U2021decs3 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int n = Integer.parseInt(st.nextToken());
	        int m = Integer.parseInt(st.nextToken());
	        long[] leftcnt = new long[m + 1];
	        long[] rightcnt = new long[m + 1];
	        for(int i=1; i <= n; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int a = Integer.parseInt(st.nextToken());
	        	int b = Integer.parseInt(st.nextToken());
	        	leftcnt[a]++;
	        	rightcnt[b]++;
	        }

	        long[] cnt = new long[2*m + 2];
	        for(int i = 0; i <= m; i++) {
	        	for(int j = 0; j <= m; j++) {
	        		cnt[i+j] += leftcnt[i] * leftcnt[j];
	        		cnt[i+j+1] -= rightcnt[i] * rightcnt[j];
	        	}
	        }
	        long[] prefix = new long[2*m + 2];
	        prefix[0] = cnt[0];
	        for(int i=1; i <= 2*m; i++) {
	        	prefix[i] = prefix[i-1] + cnt[i];
	        }
 	        
	        for(int i=0; i <= 2*m; i++) {
	        	System.out.println(prefix[i]);
	        }
	 }
}
