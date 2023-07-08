package com.deltacoding.lab;

import java.io.*;
import java.util.*;

public class P1010 {

	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(f.readLine());
		calc(n);
	}

	/**
	 * 幂为0、1、2则直接输出，>=3则递归求解。
	 */
	static void calc(int n) {
		
		if(n == 0)
			return;

	    int i=0; // 指数
	    while(n>=(1<<i)) {
	        i++;
	    }
	    i--; //找到最大的幂
	    n-=(1<<i);
	    
        if(i==1)
        	System.out.print("2"); //注意1次幂是2而不是2(1)
        if( i==0 || i == 2 )
        	System.out.print("2(" + i + ")");//幂为0、1、2时可输出幂(幂1时无输出)
        //如果幂>2，对幂递归，不输出幂。
        if(i>2) {
        	System.out.print("2(");
            calc(i);
            System.out.print(")");
        } //递归求解，再添加右括号。
        
        // 分解剩余的n
        if(n>0) {
        	System.out.print("+");
            calc(n);
        } //子问题与子问题之间用+连接;处理剩余的n(子问题)。
	}
}
