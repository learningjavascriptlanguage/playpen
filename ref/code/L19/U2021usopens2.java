package com.deltacoding.usaco.s2020_2021.usopen2021.silver;
import java.io.*;
import java.util.*;

public class U2021usopens2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int u = 0; u < T; u++) {
			int N = Integer.parseInt(in.readLine());
			long[] a = new long[7];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			TreeSet<Long> set = new TreeSet<>();
			for (int i = 0; i < N; i++) {
				set.add(a[i]);
				for (int j = 0; j < N; j++) {
					if(i == j) {
						continue;
					}
					set.add(Math.abs(a[i] - a[j]));
					for (int k = 0; k < N; k++) {
						if (k != i && k != j && a[i] + a[j] != a[k]) {
							set.add(Math.abs(a[i] + a[j] - a[k]));
							if ((a[i] + a[j] - a[k]) % 2 == 0) { // (A+B+C) + A -(B+C) = 2A
								set.add(Math.abs(a[i] + a[j] - a[k]) / 2);
							}
						}
					}
				}
			}

			int cnt = set.size();
			long[] candidate = new long[cnt]; // A,B,C可能的值
			for (int i = 0; i < cnt; i++) {
				candidate[i] = set.pollFirst();
			}
			int ans = 0;
			for (int x = 0; x < cnt; x++)
				for (int y = x; y < cnt; y++)
					for (int z = y; z < cnt; z++) {
						long A = candidate[x], B = candidate[y], C = candidate[z];
						boolean check = true;
						for (int i = 0; i < N; i++)
							if (a[i] != A && a[i] != B && a[i] != C && a[i] != A + B 
								&& a[i] != A + C && a[i] != B + C && a[i] != A + B + C) {
								check = false;
								break;
							}

						if (check) {
							ans++;
						}
					}

			System.out.println(ans);
		}
	}
}
