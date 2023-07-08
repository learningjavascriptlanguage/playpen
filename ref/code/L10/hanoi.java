package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class hanoi {
	static int cnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n;
		n = Integer.parseInt(f.readLine());
		hanoiTower(n, 'A', 'B', 'C');
		System.out.println(cnt);
	}
	
	static void hanoiTower(int n, char a, char b, char c) {
		cnt++;
		if (n == 1)
			System.out.println(a + "->" + c);
		else {
			hanoiTower(n-1, a, c, b);
			System.out.println(a + "->" + c);
			hanoiTower(n-1, b, a, c);
		}
			
	}

}
