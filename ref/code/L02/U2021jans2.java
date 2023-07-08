package com.deltacoding.usaco.s2020_2021.jan2021.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class U2021jans2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] prefix = new int[N + 2];
		int[] suffix = new int[N + 2];
		String s = in.readLine();

        // prefix sum
		for (int c = 'A'; c <= 'Z'; c++) {
			int cnt = 0;
			boolean brushdown = false;
			for (int i = 1; i <= N; i++) {
				if (s.charAt(i-1) == c) {
					if (!brushdown) {
						brushdown = true;
						cnt++;
					}
				}
				if (s.charAt(i-1) < c) {
					brushdown = false;
				}
				prefix[i] += cnt;
			}
		}

		// suffix sum
		for (int c = 'A'; c <= 'Z'; c++) {
			int cnt = 0;
			boolean brushdown = false;
			for (int i = N; i > 0; i--) {
				if (s.charAt(i-1) == c) {
					if (!brushdown) {
						cnt++;
						brushdown = true;
					}
				}
				if (s.charAt(i-1) < c) {
					brushdown = false;
				}
				suffix[i] += cnt;
			}
		}

		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			System.out.println(prefix[l - 1] + suffix[r + 1]);
		}
	}
}
