package com.deltacoding.usaco.s2020_2021.feb2021.silver;
import java.io.*;
import java.util.*;

public class U2021febs2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<n; i++) {
			int t = Integer.parseInt(in.readLine());
			set.add((t+11)/12);
		}
		n = set.size();
		int[] a = new int[n];
		int cnt = 0;
		while(!set.isEmpty()) {
			a[cnt] = set.pollFirst();
			cnt++;
		}
		Integer[] interval = new Integer[n];
		interval[0] = a[0] - 1; // 和起点的间隔
		for(int i = 1; i < n; i++) {
			interval[i] = a[i] - a[i-1] - 1;
		}
		
		Arrays.sort(interval, Collections.reverseOrder());
		
		int saved = 0;
		for (int i = 0; i < k -1 ; i++) { // 跳k次，可以减少k-1段间隔
			saved += interval[i];
		}
		int ans = (a[n-1] - saved) * 12;
		System.out.println(ans);
	}

}
