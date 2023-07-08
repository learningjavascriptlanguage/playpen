package com.deltacoding.usaco.s2016_2017.jan2017.silver;

import java.io.*;
import java.util.*;

public class hps {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

		int n = Integer.parseInt(in.readLine());
        int[] h = new int[n+1];
        int[] p = new int[n+1];
        int[] s = new int[n+1];
		for (int i = 1; i <= n; i++) {
			String gesture = in.readLine();
			h[i] = h[i-1];
			p[i] = p[i-1];
			s[i] = s[i-1];
			// H:0, P:1， S:2
			if (gesture.equals("H"))
				h[i]++;
			if (gesture.equals("P"))
				p[i]++;
			if (gesture.equals("S"))
				s[i]++;
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			// switch gestures at most once
			int first = Math.max(h[i], Math.max(p[i], s[i]));
			int second = Math.max(h[n]-h[i], Math.max(p[n]-p[i], s[n]-s[i]));
			ans = Math.max(ans, first + second);
		}

		out.println(ans);
		in.close();
		out.close();
	}

}
