package com.deltacoding.usaco.s2019_2020.dec2019.silver;

import java.io.*;
import java.util.*;

public class moobuzz {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int n = Integer.parseInt(in.readLine());
        int[] num={1, 2, 4, 7, 8, 11, 13, 14};
        int answer = (n-1) / 8 * 15 + num[(n-1) % 8];
		out.println(answer);
		out.close();
	}
}