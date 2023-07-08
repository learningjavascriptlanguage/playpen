package com.deltacoding.usaco.s2015_2016.jan2016.silver;

import java.io.*;
import java.util.*;

public class div7 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("div7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));

		int n = Integer.parseInt(in.readLine());
		int[] first = new int[7];
		int[] last = new int[7];
		Arrays.fill(first, Integer.MAX_VALUE);
		int prefix = 0;
		for(int i = 1; i <= n; i++) {
			prefix += Integer.parseInt(in.readLine());
			prefix %= 7;  // prefix = prefix % 7;
			first[prefix] = Math.min(first[prefix], i);
			last[prefix] = i;
		}
		int ans = 0;
		for(int i = 0; i < 7; i++) {
			ans = Math.max(ans, last[i] - first[i]);
		}
		out.println(ans);
		in.close();
		out.close();
	}
}
