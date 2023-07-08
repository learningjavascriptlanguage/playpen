package com.deltacoding.usaco.s2015_2016.dec2015.silver;

import java.io.*;
import java.util.*;

public class bcount {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] p1 = new int[n+1];
		int[] p2 = new int[n+1];
		int[] p3 = new int[n+1];
		for(int i = 1; i <= n; i++) {
			int curr = Integer.parseInt(in.readLine());
			p1[i] = p1[i-1];
			p2[i] = p2[i-1];
			p3[i] = p3[i-1];
			if(curr == 1) {
				p1[i]++;
			}
			if(curr == 2) {
				p2[i]++;
			}
			if(curr == 3) {
				p3[i]++;
			}
			
		}
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			out.println((p1[b] - p1[a-1]) + " " + (p2[b] - p2[a-1]) + " " + (p3[b] - p3[a-1]));
		}
		out.close();
	}

}
