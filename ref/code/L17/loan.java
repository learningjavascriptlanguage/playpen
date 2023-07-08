package com.deltacoding.usaco.s2019_2020.jan2020.silver;
import java.io.*;
import java.util.*;

public class loan {
	static long n, k, m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("loan.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		long l = 1, r = n, answer = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (check(mid)) {
				answer = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		out.println(answer);

		out.close();
	}

	static boolean check(long x) {
		long g = 0, leftDays = k;
		while (leftDays > 0) {
			long y = (n - g) / x;
			if (y <= m) {
				g += leftDays*m;
				return g >= n;
			}
			long cnt = Math.min(leftDays, 1 + (n - g) % x / y);
			g += y * cnt;
			leftDays -= cnt;
			if(g >= n) return true;
		}
    	return false;
	}
}