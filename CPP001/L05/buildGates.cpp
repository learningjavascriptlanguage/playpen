#include <bits/stdc++.h>
using namespace std;

struct point {
	int x, y;
};

bool vis[4005][4005];
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };
int T = INT_MAX, B = 0, L = INT_MAX, R = 0;

void bfs(int x, int y) {
	queue<point> q;
	q.push({ x, y });
	vis[x][y] = true;
	while (!q.empty()) {
		point curr = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = curr.x + dx[i];
			int ny = curr.y + dy[i];
			if (nx >= T && nx <= B && ny >= L && ny <= R
				&& !vis[nx][ny]) {
				q.push({ nx, ny });
				vis[nx][ny] = true;
			}
		}
	}
}

int main() {
	//freopen("gates.in", "r", stdin);
	//freopen("gates.out", "w", stdout);

	ios::sync_with_stdio(false);
	cin.tie(0), cout.tie(0);

	int n;
	string s;
	cin >> n >> s;

	int currX = 2002;
	int currY = 2002;
	vis[currX][currY] = true;
	for (int i = 0; i < s.length(); i++) {
		int dirX = 0, dirY = 0;
		if (s[i] == 'N') {
			dirX = -1;
		}
		else if (s[i] == 'S') {
			dirX = 1;
		}
		else if (s[i] == 'W') {
			dirY = -1;
		}
		else {
			dirY = 1;
		}

		for (int j = 0; j < 2; j++) {
			currX += dirX;
			currY += dirY;
			vis[currX][currY] = true;
		}

		// 裁剪空白边框
		T = min(T, currX);
		B = max(B, currX);
		L = min(L, currY);
		R = max(R, currY);
	}
	// 留一圈空白
	T--;
	B++;
	L--;
	R++;

	int ans = 0; // 连通块数
	for (int i = T; i <= B; i++) {
		for (int j = L; j <= R; j++) {
			if (!vis[i][j]) {
				ans++;
				bfs(i, j);
			}
		}
	}
	cout << ans - 1 << endl;

	return 0;
}