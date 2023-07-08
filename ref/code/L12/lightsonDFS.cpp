#include <bits/stdc++.h>
using namespace std;

const int DIR[4][2] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

struct point {
    int x, y;
};

int n, m, cnt;
bool lit[110][110], vis[110][110];
vector<point> rooms[110][110];

void dfs(int x, int y) {
    if (vis[x][y]) return;
    vis[x][y] = true;
    vector<point> switches = rooms[x][y];
    for (auto s : switches) {
        int tempx = s.x;
        int tempy = s.y;
        if (!lit[tempx][tempy]) {
            lit[tempx][tempy] = true;
            // 查找之前漏走的房间
            for (int i = 0; i < 4; i++) {
                int nx = tempx + DIR[i][0];
                int ny = tempy + DIR[i][1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && vis[nx][ny]) {
                    dfs(tempx, tempy);
                    break;  // 只要执行一次就可以了
                }
            }
        }
    }

    for (int i = 0; i < 4; i++) {
        int nx = x + DIR[i][0];
        int ny = y + DIR[i][1];
        if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && lit[nx][ny]) {
            dfs(nx, ny);
        }
    }
}

int main() {
    // freopen("lightson.in","r",stdin);
    // freopen("lightson.out","w",stdout);
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        rooms[a][b].push_back({c, d});
    }
    lit[1][1] = true;  // 开始只有(1,1)这个房间的灯是亮着
    dfs(1, 1);

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (lit[i][j]) cnt++;
        }
    }
    cout << cnt << endl;
    return 0;
}
