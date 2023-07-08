package com.deltacoding.usaco.s2016_2017.jan2017.silver;

import java.io.*;
import java.util.*;

public class cowdance {
	static int n;
	static int maxT;
	static int[] t;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		maxT = Integer.parseInt(st.nextToken());
		t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(in.readLine());
		}
		int left = 1;
		int right = n;
		int ans = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		out.println(ans);
		in.close();
		out.close();
	}

	public static boolean check(int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int i=0; i<k; i++) {
	        pq.offer(t[i]);
	    }
	    for(int i=k; i<n; i++) {
	        int a = pq.poll();
	        pq.offer(a + t[i]);
	    }
	    while(pq.size() > 1) {
	        pq.poll();
	    }
	    return pq.poll() <= maxT;
	}
}
