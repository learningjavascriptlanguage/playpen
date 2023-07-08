package com.deltacoding.usaco.s2019_2020.dec2019.silver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkvisits_UFDS {
        static int[] f;	    

		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new FileReader("milkvisits.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
			StringTokenizer tk = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(tk.nextToken()); // farms
			int m = Integer.parseInt(tk.nextToken()); // friends
			String cowType = in.readLine();
			f = new int[n+1];
			for(int i=1;i<=n;i++){
		        f[i]=i;
		    }
		    for(int i=0;i<n-1;i++){
		    	tk = new StringTokenizer(in.readLine());
		        int x = Integer.parseInt(tk.nextToken());
		        int y = Integer.parseInt(tk.nextToken());
		        if(cowType.charAt(x-1) == cowType.charAt(y-1)) {
		            merge(x,y);
		        }
		    }

		    for(int i=0;i<m;i++){
		        tk = new StringTokenizer(in.readLine());
		        int a = Integer.parseInt(tk.nextToken());
		        int b = Integer.parseInt(tk.nextToken());
		        char c = tk.nextToken().charAt(0);
		        if(find(a)==find(b) && cowType.charAt(a-1) != c){
		        	out.print(0);
		        } else {
		        	out.print(1);
		        }
		    }
			out.println();
			out.close();
		}

		static int find(int v){
		    if(f[v]==v) return v;
		    f[v]=find(f[v]);
		    return f[v];
		}

		static void merge(int u,int v){
		    int fu=find(u);
		    int fv=find(v);
		    if(fu!=fv){
		        f[fv]=fu;
		    }
		}
}
