package com.deltacoding.usaco.s2021_2022.jan2021.silver;

import java.io.*;
import java.util.*;

public class u2022jans2 {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(in.readLine());
    	int[] a = new int[n + 1];
    	long ans = 0;
    	StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
    		a[i] = Integer.parseInt(st.nextToken());
    	}
        
    	Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (s.size() > 0 && a[i] > a[s.peek()]) {
                ans += i - s.peek() + 1;
                s.pop();
            }
            if (s.size() > 0) {
				ans += i - s.peek() + 1;
			}
            s.push(i);
    	}
    	out.println(ans);
    	in.close();
    	out.close();
	}

}
