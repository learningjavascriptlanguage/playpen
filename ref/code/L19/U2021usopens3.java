package com.deltacoding.usaco.s2020_2021.usopen2021.silver;
import java.io.*;
import java.util.*;

public class U2021usopens3 {
	static int N, K, L;
	static Integer[] a;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		a = new Integer[N + 1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a, 1, N+1, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
			    return o2 - o1;  // 从大到小
			}
		});
   
	    int l = 0, r = N;
	    int ans = 0;
	    while (l <= r) {
	        int mid = l + r >> 1;
	        if (check(mid)) {
	            ans = mid;
	            l = mid + 1;
	        } else {
	            r = mid - 1;
	        }
	    }
	    System.out.println(ans);
	}
	
	static boolean check(int mid) {
	    long sum = 0;
	    for (int i = 1; i <= mid; i++) {
	    	if(mid - a[i] > K) {
	    		return false;
	    	}
	    	sum += Math.max(0, mid - a[i]);
	    }

	    return sum <= (long)K * L;
	}

}
