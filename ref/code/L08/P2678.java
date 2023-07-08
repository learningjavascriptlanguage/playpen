package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2678 {
	static int n;
	static int m;
	static int[] stone;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int L = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		stone = new int[n+2];
		for(int i=1; i<=n; i++) {
			stone[i] = Integer.parseInt(in.readLine());
		}
		stone[n+1] = L;
		int left = 1;
		int right = L;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	static boolean check(int mid) {
		int cnt = 0;
		int currentPos = 0;
		for(int i=1; i<=n+1; i++) {
			if(stone[i] - stone[currentPos] < mid) {
				cnt++;
			} else {
				currentPos = i;
			}
		}

		return cnt <= m;
	}
}