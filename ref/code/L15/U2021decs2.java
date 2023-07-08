package com.deltacoding.usaco.s2021_2022.dec2021.silver;

import java.io.*;
import java.util.*;

public class U2021decs2 {
	static int[] f;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < T; i++) {
			singledata(in);
		}

	}
	
	static void singledata(BufferedReader in) throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
		f = new int[n + 1];
		
		ArrayList<Integer>[] lists = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<>();
			f[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			merge(a, b);
		}

		int f1 = find(1);
		int fn = find(n);
		if(f1 == fn) {
			System.out.println(0);
			return;
		}

		for(int i = 1; i<=n; i++) {
			lists[find(i)].add(i);
		}
	
		int[] arrf1 = new int[lists[f1].size()];
		for(int i=0; i<arrf1.length; i++) {
			arrf1[i] = lists[f1].get(i);
		}
		int[] arrfn = new int[lists[fn].size()];
		for(int i=0; i<arrfn.length; i++) {
			arrfn[i] = lists[fn].get(i);
		}
		
		long ans = Long.MAX_VALUE;
		for(int i = 2; i <= n-1; i++) {
			if(find(i) != i) {
				continue;
			}
			long min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; // 确保min1*min1在long范围内
			for(int node : lists[i]) { // 枚举该连通块中每一个点
				int pos = binarySearch(arrf1, node); // 找大于等于且最接近node的数的位置
				if(pos < arrf1.length) {
					min1 = Math.min(min1, arrf1[pos] - node);
				}
				if(pos > 0) {
					min1 = Math.min(min1, node - arrf1[pos - 1]);
				}

				pos = binarySearch(arrfn, node); // 找大于等于且最接近node的数的位置
				if(pos < arrfn.length) {
					min2 = Math.min(min2, arrfn[pos] - node);
				}
				if(pos > 0) {
					min2 = Math.min(min2, node - arrfn[pos - 1]);
				}
			}
			
			ans = Math.min(ans, min1 * min1 + min2 * min2);
		}
		System.out.println(ans);
	}
	
	static int binarySearch(int[] arr, int key) {
		int l = 0, r = arr.length - 1;
		int ans = arr.length;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(arr[mid] >= key) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;
	}

	static void merge(int x, int y) {
		int fx = find(x);
		int fy = find(y);
		if(fx != fy) {
			f[fy] = fx;
		}
	}
	
	static int find(int u) {
		if (f[u] == u) {
			return u;
		}

		f[u] = find(f[u]); // 路径压缩

		return f[u];
	}
}
