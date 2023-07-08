import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
第一行表示有10个强盗， 9条线索
input
10 9
1 2
3 4
5 2
4 6
2 6
8 7
9 7
1 6
2 4

output
3
*/
public class UFDSSample {
	static int[] f;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n, leads;
		n = Integer.parseInt(st.nextToken());
		leads = Integer.parseInt(st.nextToken());
		f = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}
		for (int i = 0; i < leads; i++) {
			int x, y;
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			merge(x, y);
		}

		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(f[i] == i) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	static void merge(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		if(rootx != rooty) {
			f[rooty] = rootx;
		}
	}
	
	static int find(int u) {
		if (f[u] == u) {
			return u;
		}

		f[u] = find(f[u]); // 路径压缩

		return f[u];
	}

}
