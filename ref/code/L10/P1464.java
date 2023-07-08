package com.deltacoding.lab;

import java.io.*;
import java.util.*;

class P1464 {
	static long[][][] e = new long[21][21][21];

	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while (!(s = f.readLine()).equals("-1 -1 -1")) {
			String[] ss = s.split(" ");
			int[] num = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i] = Integer.parseInt(ss[i]);
			}

			int a = num[0];
			int b = num[1];
			int c = num[2];

			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));

		}
	}

	public static long w(long x, long y, long z) {

		if (x <= 0 || y <= 0 || z <= 0)
			return 1L;

		if (x > 20 || y > 20 || z > 20)
			return w(20, 20, 20);
		int a = (int) x, b = (int) y, c = (int) z;

		if (e[a][b][c] > 0)
			return e[a][b][c];// abc cannot exceed 20 then

		if (a < b && b < c) {
			e[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

		} else {
			e[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}
		return e[a][b][c];
	}
}
