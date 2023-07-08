package com.deltacoding.usaco.s2017_2018.dec2017.silver;

import java.io.*;
import java.util.*;

public class measurement {

	static class Log {
		int day;
		int cowId;
		int delta;

		public Log(int day, int cow, int delta) {
			this.day = day;
			this.cowId = cow;
			this.delta = delta;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		int n, g;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());

		// 存储每头奶牛总的产奶变化量
		// key: cowid  value: 该头牛总的产奶变化量
		Map<Integer, Integer> eachCowOutput = new HashMap<>();

		Log[] logs = new Log[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int cowId = Integer.parseInt(st.nextToken());
			int delta = Integer.parseInt(st.nextToken());
			logs[i] = new Log(day, cowId, delta);
			eachCowOutput.put(cowId, 0);
		}

		Arrays.sort(logs, new Comparator<Log>() {

			@Override
			public int compare(Log o1, Log o2) {
				return Integer.compare(o1.day, o2.day); // 按时间从小到大排序
			}
		});

		// 按总的产奶变化量降序排列
		// Key: 产奶变化量， value: 对应的奶牛数
		TreeMap<Integer, Integer> totalOutput = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;  // 按照key从大到小排序
			}
		});

		// Note that Farmer John has a very large herd of cows, so although some of 
		// them are noted in his log book as changing their milk production, there are
		// always plenty of other cows around whose milk output level remains at G gallons.
		// 确保总的产奶变化量为0始终存在
		totalOutput.put(0, n+1);
		int answer = 0;

		for (int i = 0; i < n; i++) {
			int milk = eachCowOutput.get(logs[i].cowId); // 产奶量
			boolean wasTop = (milk == totalOutput.firstKey()); // 更新前是不是冠军 
			int wasCnt = totalOutput.get(milk);
			
			if (wasCnt == 1) {
				totalOutput.remove(milk);
			} else if (wasCnt > 1) {
				totalOutput.put(milk, wasCnt - 1);
			}
			
			milk += logs[i].delta;  // 计算出该头牛新的产奶变化量
			eachCowOutput.put(logs[i].cowId, milk);

			int isCnt = 1;
			if (totalOutput.get(milk) != null) {
				isCnt += totalOutput.get(milk);
			}
			totalOutput.put(milk, isCnt);
			// 检查是否需要更新图片
			boolean isTop = (milk == totalOutput.firstKey()); // 更新后是不是冠军

			if (wasTop != isTop) {
				answer++;
			} else if (wasTop && isTop && wasCnt != isCnt) {
				answer++;
			}
		}
		
		pw.println(answer);
		br.close();
		pw.close();
	}
}
