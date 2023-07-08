#include <bits/stdc++.h>
using namespace std;

struct point {
	int x, y;
};

int dx[4] = { -1, 1, 2, -2 };
int dy[4] = { 1, -1, 2, -2 };
int a[401][401];
bool vis[401][401];
int n, m;
queue<point> q;

void bfs(int x, int y, int step) {
	q.push({ x, y });
	vis[x][y] = true;
	a[x][y] = step;
	while (!q.empty()) {
		point curr = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			for(int j=0; j<4;j++)
				if (abs(dx[i]) != abs(dy[j])) {//判断方向
					int nx = curr.x + dx[i];
					int ny = curr.y + dy[j];
					if (nx < 1 || nx > n || ny<1 || ny>m || vis[nx][ny])
						continue;//判断越界或者是否已走过

					q.push({ nx,ny });
					vis[nx][ny] = true; //标记已入队
					a[nx][ny] = a[curr.x][curr.y] + 1; //路径+1
				}
		}
	}
}

int main() {
	int x, y;
	cin >> n >> m >> x >> y;
	for(int i=1;i<=n;i++)
		for (int j = 1; j <= m; j++) {
			a[i][j] = -1;
		}
	
	bfs(x, y, 0);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			printf("%-5d", a[i][j]); //左对齐，宽5格
		}
		printf("\n");
	}

	return 0;
}
