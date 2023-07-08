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
    // TODO
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
