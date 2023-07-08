package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1177
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(f.readLine());
        int[] num = new int[n];
        StringTokenizer tk = new StringTokenizer(f.readLine());
        for(int i=0; i<n; i++) {
        	num[i] = Integer.parseInt(tk.nextToken());
        }
        quickSort(0, n-1, num);
        for(int i=0; i<n; i++) {
        	System.out.print(num[i] + " ");
        }
     }

    public static void quickSort(int left, int right, int[] num) {
    	if(left>=right)
    		return;
    	
    	int midNum = num[(left+right)/2];
    	int i = left;
    	int j = right;
    	while(i<=j) {
    		// from left to right
    		while(num[i]<midNum) {
    			i++;
    		}
    		
    		// from right to left
    		while(num[j]>midNum) {
    			j--;
    		}
    		
    		if(i<=j) {
    			int t = num[i];
    			num[i] = num[j];
    			num[j] = t;
    			i++;
    			j--;
    		}
    	}
    	
//    	for(int k=0; k<num.length; k++) {
//        	System.out.print(num[k] + " ");
//        }
//    	System.out.println();
    	
    	quickSort(left, j, num);
    	quickSort(i, right, num);
    	
    }
}
