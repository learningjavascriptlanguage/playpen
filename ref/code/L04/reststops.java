package com.deltacoding.usaco.s2017_2018.feb2018.silver;

import java.io.*;
import java.util.*;

public class reststops {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));

		int L, N, rf, rb;
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		rf = Integer.parseInt(st.nextToken());
		rb = Integer.parseInt(st.nextToken());

		int[] x = new int[N];
		int[] c = new int[N];
		boolean[] isStopped = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (c[i] > max) {
				isStopped[i] = true;
				max = c[i];
			}
		}

		long ans = 0, lastx = 0;
		for (int i = 0; i < N; i++) {
			if (isStopped[i]) {
				long t = (x[i] - lastx) * (rf - rb);
				ans +=  t * c[i];
				lastx = x[i];
			}
		}
		pw.println(ans);
		br.close();
		pw.close();

	}

}
