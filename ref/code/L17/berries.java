package com.deltacoding.usaco.s2019_2020.jan2020.silver;
import java.io.*;
import java.util.*;

public class berries {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[1001];
		st = new StringTokenizer(in.readLine());
		int maxa = 0;
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			maxa = Math.max(maxa, a[i]);
		}
		
		int answer = 0;
		for(int i=1; i<=maxa; i++) { // 第k/2多的篮子装有恰好i个果子
			int count = 0; // 最多能装出count个i个果子的篮子
			Integer[] p = new Integer[1001];
			for(int j=1; j<=n; j++) {
				count += a[j] / i;
				p[j] = a[j] % i;
			}
			Arrays.sort(p, 1, n+1, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			if(count >= k) {
				answer = Math.max(answer, k / 2 * i);
			} else if(count >= k/2) {
				int sum = (count - k/2) * i;
				for(int j=1; j<= Math.min(n, k-count); j++) { // 注意Math.min(n, k-count)
					sum += p[j];
				}
				answer = Math.max(answer, sum);
 			}
		}
		out.println(answer);
		in.close();
		out.close();
	}
}