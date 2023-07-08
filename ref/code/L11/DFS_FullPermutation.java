import java.io.*;
import java.util.*;

public class Dfs_FullPermutation {
	
	static int n;
	static int[] a, ans;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		a = new int[n+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
	    for(int i=1; i<=n; i++) {
	        a[i] = Integer.parseInt(st.nextToken());
	    }
		ans = new int[n+1];
		vis = new boolean[1001];
		dfs(1);
	}

	static void dfs(int index) {
		if(index == n+1) {
			for(int i=1; i<=n; i++) {
				System.out.print(ans[i] + " ");	
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!vis[a[i]]) {
				ans[index] = a[i];
				vis[a[i]] = true;
				dfs(index+1);
				vis[a[i]] = false;			
			}
		}
		
	}
	
}