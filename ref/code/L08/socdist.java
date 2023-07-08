package com.deltacoding.usaco.s2019_2020.usopen2020.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class socdist {
	static int N, M;
	static Interval[] ranges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("socdist.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ranges = new Interval[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			ranges[i] = new Interval(x, y);
		}

		Arrays.sort(ranges, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return Long.compare(o1.x, o2.x);
			}
		});

		long answer = 0;
		long l = 1, r = ranges[M-1].y;
		while (l <= r)
		{
			long mid = (l + r) / 2;
			
			if (check(mid)) {
				answer = mid;
				l = mid + 1;
			}			
			else {
				r = mid - 1;
			}				
		}

		out.println(answer);
		in.close();
		out.close();
	}

	static boolean check(long mid)
	{
		long cnt = 0, begin = 0;
		for (int i = 0; i < M; i++)
		{
			begin = Math.max(begin, ranges[i].x);
			if (begin <= ranges[i].y) // 确保range存在
			{
				long points = (ranges[i].y - begin) / mid + 1;
				cnt += points;
				begin += points * mid;
			}
		}

		return cnt >= N;
	}

	static class Interval {
		long x, y;

		public Interval(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
