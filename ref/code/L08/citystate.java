package com.deltacoding.usaco.s2016_2017.dec2016.silver;

import java.io.*;
import java.util.*;

public class citystate {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

		int n = Integer.parseInt(in.readLine());
		Map<String, Long> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String city = st.nextToken().substring(0, 2); // 截取前两位
			String state = st.nextToken();
			if(!city.equals(state)) { // 要求来自不同的省
				String key = city + state;
				if(!map.containsKey(key)) {
					map.put(key, 1L);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}
		}
		long ans = 0;
		for(String key : map.keySet()) {
			String pair = key.substring(2) + key.substring(0, 2); // 前两位和后两位字符对换位置
			if(map.containsKey(pair)) {
				ans += map.get(key) * map.get(pair);
			}
		}
		// note that we have double-counted each pair
		out.println(ans / 2);
		in.close();
		out.close();
	}
}
