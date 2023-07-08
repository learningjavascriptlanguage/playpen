package com.deltacoding.usaco.s2018_2019.dec2018.silver;

import java.io.*;
import java.util.*;

public class convention2 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));

		int n = Integer.parseInt(in.readLine());
		Cow[] cows = new Cow[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer tk = new StringTokenizer(in.readLine());
            int arrive = Integer.parseInt(tk.nextToken());
            int eating = Integer.parseInt(tk.nextToken());
			cows[i] = new Cow(arrive, eating, i);
		}

		Arrays.sort(cows, new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				if(c1.arrive != c2.arrive) {
					return Integer.compare(c1.arrive, c2.arrive);
				}
				return Integer.compare(c1.seniority, c2.seniority); // 不要漏掉
			}
		});

		PriorityQueue<Cow> q = new PriorityQueue<Cow>(new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				return Integer.compare(c1.seniority, c2.seniority);
			}
		});

		int answer = 0;
		int last = cows[0].arrive; // 上一头奶牛吃草结束时间
		q.offer(cows[0]);
		int cnt = 1; // 已加入到优先队列中的牛

		while (!q.isEmpty()) {
			Cow c = q.poll();
			int wait = Math.max(0, last - c.arrive);

			answer = Math.max(answer, wait);

			last = c.arrive + wait + c.t; // 当前吃草的牛结束时间

			for (int i = cnt; i < n; i++) {
				if (cows[i].arrive <= last) { // 当前吃草的牛结束时，把已经到达的牛加入队列
					q.offer(cows[i]);
					cnt++;
				} else {
					break;
				}
			}

			if (q.isEmpty() && cnt < n) { // 不能漏
				q.offer(cows[cnt]);
				cnt++;
			}
		}

		out.println(answer);
		in.close();
		out.close();

	}

	static class Cow {
		int arrive;
		int t;
		int seniority;

		public Cow(int a, int b, int c) {
			arrive = a;
			t = b;
			seniority = c;
		}
	}
}
