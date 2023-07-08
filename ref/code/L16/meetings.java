package com.deltacoding.usaco.s2019_2020.dec2019.silver;

import java.io.*;
import java.util.*;

public class meetings {
	static int n;
	static int L;
	static int totalW = 0;
	static int answer;
	static int[] position;
	static int[] r;
	static Cow[] cows;

	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new FileReader("meetings.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
	    cows = new Cow[n];
		position = new int[n];
		r = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			cows[i] = new Cow(w, x, d);
			totalW += w;
		}
		Arrays.sort(cows, new Comparator<Cow>() {
			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.x - o2.x;
			}
		});
		int left = 0, right = L;
		int time = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (check(mid)) {
				time = mid;
				right = mid - 1;
			} else
				left = mid + 1;
		}

		for (int i = 0; i < n; i++) {
			position[i] = cows[i].x + cows[i].d * time; // final position
		}

		msort(0, n - 1);
		out.println(answer);
		in.close();
		out.close();
	}

	public static boolean check(int time) {
		int lcnt = 0;
		int rcnt = 0;
		for (int i = 0; i < n; i++) {
			Cow cur = cows[i];
			if (cur.x + cur.d * time <= 0)
				lcnt++;
			if (cur.x + cur.d * time >= L)
				rcnt++;
		}
		long sum = 0;
		for (int i = 0; i < lcnt; i++) {
			sum += cows[i].w;
		}
		for (int i = 0; i < rcnt; i++) {
			sum += cows[n-1-i].w;
		}
		return sum * 2 >= totalW; // 不要写成sum >= totalW / 2; 
	}

	static class Cow {
		int w, x, d;

		public Cow(int w, int x, int d) {
			this.w = w;
			this.x = x;
			this.d = d;
		}
	}

	static void msort(int left, int right) {
		if (left == right)
			return;
		int mid = (left + right) / 2;
		msort(left, mid); // 分割左半部分区间
		msort(mid + 1, right); // 分割右半部分区间
		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) { // 合并左右区间
			if (position[i] < position[j]) {
				r[k] = position[i];
				i++;
			} else {
				r[k] = position[j];
				j++;
				answer += mid - i + 1; // 计算逆序对和相等对个数， 从a[i]~a[mid]均和a[j]构成逆序对
			}
			k++;
		}
		while (i <= mid) // 左区间有多余的数
		{
			r[k] = position[i];
			k++;
			i++;
		}

		while (j <= right) // 右区间有多余的数
		{
			r[k] = position[j];
			k++;
			j++;
		}

		for (int x = left; x <= right; x++) // 把临时数组的有序值赋值到原数组中
			position[x] = r[x];
	}

}