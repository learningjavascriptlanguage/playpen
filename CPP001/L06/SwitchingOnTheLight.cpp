#include <bits/stdc++.h>
using namespace std;

struct point {
    int x, y;
};

int n, m;
vector<point> rooms[101][101];
bool vis[101][101], lit[101][101];
int dir[4][2] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

void bfs() {
    queue<point> q;
    q.push({ 1, 1 });
    vis[1][1] = true;
    lit[1][1] = true;

    while (!q.empty()) {
        point cur = q.front();
        q.pop();
        vector<point> switches = rooms[cur.x][cur.y];
        for (auto s : switches) {
            if (!lit[s.x][s.y]) {
                lit[s.x][s.y] = true;
                for (int j = 0; j < 4; j++) {
                    int nx = s.x + dir[j][0];
                    int ny = s.y + dir[j][1];
                    if (nx < 1 || nx > n || ny < 1 || ny > n) {
                        continue;
                    }
                    if (vis[nx][ny]) {
                        q.push({ s.x, s.y });  // 查找漏网之鱼
                        vis[s.x][s.y] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dir[i][0];
            int ny = cur.y + dir[i][1];
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                continue;
            }
            if (vis[nx][ny] || !lit[nx][ny]) {
                continue;
            }
            q.push({ nx, ny });
            vis[nx][ny] = true;
        }
    }
}

int main() {
    //freopen("lightson.in", "r", stdin);
    //freopen("lightson.out", "w", stdout);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        rooms[a][b].push_back({ c, d });
    }

    bfs();
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (lit[i][j]) {
                ans++;
            }
        }
    }
    cout << ans << endl;
    return 0;
}