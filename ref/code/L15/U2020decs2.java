package com.deltacoding.usaco.s2020_2021.dec2020.silver;
import java.io.*;
import java.util.*;

public class U2020decs2 {
	static int[][] sum;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        int[] x = new int[n+1];
        int[] y = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
        	x[i] = Integer.parseInt(st.nextToken());
        	y[i] = Integer.parseInt(st.nextToken());
        }
        
        // 坐标离散化
        discrete(x);
        discrete(y);

        int[][] pasture = new int[n+1][n+1];
        int[] points = new int[n+1];
        for(int i=1; i<=n; i++) {
        	points[x[i]] = y[i];
        	pasture[x[i]][y[i]] = 1;
        }

        // 2D prefix sum
        sum = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + pasture[i][j];
        	}
        }

        long ans = n + 1; // 空集和单个点集
        for(int i=1; i<=n; i++) { // 最上端点
        	for(int j=i + 1; j<=n; j++) { // 最下端点
        		int yi = Math.min(points[i], points[j]);
        		int yj = Math.max(points[i], points[j]);
        		long left = count(i, 1, j, yi-1); // 子集左侧点数
        		long right = count(i, yj + 1, j, n); // 子集右侧点数
        		ans += (left + 1) * (right + 1); // +1 是算上空集
        	}
        }
        
        System.out.println(ans);
	}

	static void discrete(int[] coordinate) {
		Map<Integer, Integer> discrete = new HashMap<>();
        int[] t = Arrays.copyOf(coordinate, coordinate.length);
        Arrays.sort(t, 1, t.length);
        for(int i=1; i<=n; i++) {
        	discrete.put(t[i], i);
        }
        for(int i=1; i<=n; i++) {
        	coordinate[i] = discrete.get(coordinate[i]);
        }
		return;
	}

	static int count(int x1, int y1, int x2, int y2) // (x1, y1)左上角 （x2, y2）右下角
	{
	    return sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
	}

}
