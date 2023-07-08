package com.deltacoding.luogu;

import java.io.*;
import java.util.*;

public class P1219 {

	static int n;
	static int[] answer;
	static boolean[] b; // columns
	static boolean[] c; // '/'
	static boolean[] d; // '\'
	
	public static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken()); //size of board n x n
		answer=new int[n+1];
		b=new boolean[n+1];
		c=new boolean[2*n+1];
		d=new boolean[2*n+1];

		dfs(1);
		System.out.println(total);
	}

	public static void dfs(int row) {
		if(row==n+1) {
			total++;
			
			if(total<=3) {
				for(int i=1; i<=n; i++) {
					System.out.print(answer[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int col=1; col<=n; col++) {
			if(!b[col] && !c[row+col] && !d[row-col+n]) {
				answer[row]=col; //queen on row, col
				b[col]=true;
				c[row+col]=true; //all values in this / have indices adding up to row+col
				d[row-col+n]=true;
				
				dfs(row+1);
				
				b[col]=false;
				c[row+col]=false;
				d[row-col+n]=false;
			}
		}
	}
	
}
