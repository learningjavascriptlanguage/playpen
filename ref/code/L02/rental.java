package com.deltacoding.usaco.s2017_2018.jan2018.silver;

import java.io.*;
import java.util.*;

/*
Let f(i) be the maximum amount of money we can make just by using the milk from the
i cows that produce the most milk, and let g(j) be the maximum amount of money we can
make just by renting the j cows that produce the least milk. We want to compute the
maximum possible value of f(i) + g(N − i)
 *
 */
public class rental {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("rental.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		Integer[] milkProduced = new Integer[n];
		for(int i = 0; i < n; i++) {
			milkProduced[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(milkProduced, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1); // descend order by milk
			}
		});
		
		Shop[] shops = new Shop[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			shops[i] = new Shop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(shops, new Comparator<Shop>() {

			@Override
			public int compare(Shop o1, Shop o2) {// descend order by milk price
				return o2.price - o1.price;
			}
		});

		Integer[] rental = new Integer[r];
		for(int i = 0; i < r; i++) {
			rental[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(rental, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1); // descend order by rental price
			}
		});

		long[] maxProfit = new long[n+1]; // maxProfit[i]前i-1头牛用来卖奶
		int shopIndex = 0; // 商店下标
		for(int i = 0; i < n; i++) {
			maxProfit[i+1] = maxProfit[i];
			while(shopIndex < m && milkProduced[i] > 0) {
				int change = Math.min(milkProduced[i], shops[shopIndex].quantity);
				maxProfit[i+1] += change * shops[shopIndex].price;
				milkProduced[i] -= change;
				shops[shopIndex].quantity -= change;
				if(shops[shopIndex].quantity == 0) {
					shopIndex++;
				}
			}
		}

		int rentalCnt = 0;
		long rentalSoFar = 0;
		for(int i=n-1; i >= 0 && rentalCnt < r; i--) {
			rentalSoFar += rental[rentalCnt];   // 剩余的奶牛出租可以得到的利润
			maxProfit[i] += rentalSoFar; // prefix sum array
			rentalCnt++;
		}

		long ans = 0;
		for(long profix: maxProfit) {
			ans = Math.max(ans, profix);
		}
		out.println(ans);
		in.close();
		out.close();
	}

	static class Shop {
		public int quantity, price;
		public Shop(int a, int b) {
			quantity=a;
			price=b;
		}
	}

}