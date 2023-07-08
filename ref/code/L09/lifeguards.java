package com.deltacoding.usaco.s2017_2018.jan2018.silver;

import java.io.*;
import java.util.*;

public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

		int n = Integer.parseInt(in.readLine());
		Point[] points = new Point[2*n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			points[i] = new Point(start, i);
			points[i+n] = new Point(end, i);
		}
		Arrays.sort(points); // 按照时间从小到大排序
		int sum = 0;
		int[] alone = new int[n]; // 每头牛单独覆盖的区域
		int last = 0; // 上一个点的时间

		// Maintain a set of lifeguards that are known to be working.
		Set<Integer> set = new HashSet<>();

		for(Point p : points) {
			// If exactly one lifeguard is working, track that this is time that will be lost if that lifeguard gets fired. 
			if(set.size() == 1) {
				alone[set.iterator().next()] += p.time - last;
			}

			if(set.size() > 0) {
				sum += p.time - last;
			}

			if(set.contains(p.id)) { // It says this State is the end point of a time interval.
				set.remove(p.id);
			}
			else {
				set.add(p.id);
			}

			last = p.time;
		}
		
		int min = Integer.MAX_VALUE;
		for(int t : alone) {
			min = Math.min(min, t);
		}
		out.println(sum - min);
		in.close();
		out.close();
	}
	
	static class Point implements Comparable<Point> {
		int time, id;
		public Point(int time, int id) {
			this.time=time;
			this.id=id;
		}

		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}
	
}