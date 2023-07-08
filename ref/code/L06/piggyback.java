import java.io.*;
import java.util.*;

public class piggyback {
	static LinkedList<Edge>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("piggyback.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int b, e, p, n, m;
		b = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edges = new LinkedList[n];
		int[] point1Distance = new int[n];
		int[] point2Distance = new int[n];
		int[] pointnDistance = new int[n];

		for (int i = 0; i < n; i++) {
			edges[i] = new LinkedList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			edges[from].add(new Edge(to));
			edges[to].add(new Edge(from));
		}

		bfs(0, point1Distance, n);
		bfs(1, point2Distance, n);
		bfs(n - 1, pointnDistance, n);
		
		Long ans = Long.MAX_VALUE;
		for(int i=0; i<n; i++) {
			ans = Math.min(ans, point1Distance[i]*b + point2Distance[i]*e + pointnDistance[i]*p);
		}
		pw.print(ans);
		pw.close();
	}

	static void bfs(int start, int[] distance, int n) {
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);
		distance[start] = 0;
		visited[start] = true;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (Edge out : edges[curr]) {
				if (!visited[out.to]) {
					queue.add(out.to);
					distance[out.to] = distance[curr] + 1;
					visited[out.to] = true;
				}
			}
		}
	}

	static class Edge {
		public int to;

		public Edge(int to) {
			this.to = to;
		}
	}
}