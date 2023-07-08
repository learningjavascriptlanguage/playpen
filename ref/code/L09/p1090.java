package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1090 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return  o1 - o2; 
			}
			
		});        
        
		StringTokenizer tk = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++)
        {
        	int w = Integer.parseInt(tk.nextToken());
        	pq.offer(w);
        }
        
        int ans=0;
        for(int i=0; i<n-1; i++)
        {
        	int w = pq.poll() + pq.poll();
        	ans+=w;
        	pq.offer(w);
        }

        System.out.print(ans);

	}

}
