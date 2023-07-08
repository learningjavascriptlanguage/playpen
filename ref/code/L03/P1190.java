import java.io.*;
import java.util.*;

public class P1190 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        
        int[] cock = new int[m];
        tk = new StringTokenizer(in.readLine());
        for(int i=0; i<m; i++) {
        	cock[i] = Integer.parseInt(tk.nextToken());
        }
        
        for(int i=m; i<n; i++) {
        	int w = Integer.parseInt(tk.nextToken());
        	
        	int min = Integer.MAX_VALUE, pos = -1;
        	for(int j=0; j<m; j++) {
        		if(min > cock[j]) {
        			min = cock[j];
        			pos = j;
        		}
        	}
        	
        	cock[pos] += w;
        }
        
        int ans = 0;
        for(int i=0; i<m; i++) {
        	ans = Math.max(ans, cock[i]);
        }
        
        System.out.println(ans);
	}
}