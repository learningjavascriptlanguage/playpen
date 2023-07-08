package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1028 {
	public static long[] record = new long[1001];
	
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(f.readLine());
		System.out.println(f(n));
	}

	public static long f(int n) {
		// query
		if(record[n]>0)
			return record[n];
		
		if(n==1) {
			return 1;
		}
		
		long ans = 1;
		for (int i = 1; i <= n / 2; i++) {
			ans+=f(i);
		}
		// save
		record[n]=ans;
		
		return ans;
	}

}
