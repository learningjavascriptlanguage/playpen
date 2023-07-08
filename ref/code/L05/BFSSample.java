import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSSample {
	// direction
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static class Point {
		int x, y, step;
		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int row, col;
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int[][] maze = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<col; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		int sx, sy, ex, ey;
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sx, sy, 0)); // 星星之火可以燎原
		visited[sx][sy]=true;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			for(int i=0; i<4; i++) {
				int nx = current.x + dir[i][0];
				int ny = current.y + dir[i][1];
				// 判断是否越界
				if(nx<0 || nx >= row || ny <0 || ny>=col) {
					continue;
				}
				if(maze[nx][ny] == 0 && !visited[nx][ny]) {
					q.offer(new Point(nx, ny, current.step + 1));
					visited[nx][ny]=true;
					if(nx == ex && ny == ey) {
						System.out.println("到达终点，最少需" + (current.step + 1) + "步");
						return;
					}
				}
				
			}
		}
		
		System.out.println("无法到达终点");

	}

}
