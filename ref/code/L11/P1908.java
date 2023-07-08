package com.deltacoding.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1908 {
    static long answer=0; //逆序对的数量
    static int[] data;
    static int[] temp;
    
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
	    data = new int[n+1];
	    temp = new int[n+1];
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    for(int i=1;i<=n;i++) {
	    	data[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    msort(1,n);
	    System.out.println(answer);
	}

	static void msort(int left,int right){
	    if(left==right) return;
	    int mid=(left+right)/2;
	    msort(left, mid); // 分割左半部分区间
	    msort(mid+1, right); // 分割右半部分区间
	    int i=left,j=mid+1,k=left;
	    while(i<=mid && j<=right){  // 合并左右区间
	        if(data[i]<=data[j]){
	            temp[k]=data[i];
				i++;
	        } 
	        else{
	            temp[k]=data[j];
				j++;
				answer+=mid-i+1; // 计算逆序对个数， 从a[i]~a[mid]均和a[j]构成逆序对
	        }
	        k++;
	    }
	    while(i<=mid) // 左区间有多余的数
	    {
	    	temp[k]=data[i];
	    	k++;
	    	i++;
		}

	    while(j<=right) // 右区间有多余的数
	    {
			temp[k]=data[j];
			k++;
			j++;
		}
	        
	    for(int x=left;x<=right;x++) // 把临时数组的有序值赋值到原数组中
	        data[x]=temp[x];
	}
}
