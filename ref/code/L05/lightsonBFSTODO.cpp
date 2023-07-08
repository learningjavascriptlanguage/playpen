#include <bits/stdc++.h>
using namespace std;

struct point {
    int x, y;
};

int n, m;
vector<point> rooms[101][101];
bool vis[101][101], lit[101][101];
int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

void bfs() {
    queue<point> q;
    q.push({1, 1});
    // TODO
}

int main() {
    freopen("lightson.in", "r", stdin);
    freopen("lightson.out", "w", stdout);

    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;
        rooms[a][b].push_back({c, d});
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
