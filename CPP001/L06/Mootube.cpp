#include <bits/stdc++.h>
using namespace std;

struct edge {
    int to, w;
};

vector<edge> g[5001];

int bfs(int k, int v) {
    int ans = 0;
    bool vis[5001] = {};
    queue<int> q;
    q.push(v);
    vis[v] = true;
    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (auto& e : g[cur]) {
            if (!vis[e.to] && e.w >= k) {
                q.push(e.to);
                vis[e.to] = true;
                ans++;
            }
        }
    }
    return ans;
}

/*
SAMPLE INPUT:
4 3
1 2 3
2 3 2
2 4 4
1 2
4 1
3 1
SAMPLE OUTPUT:
3
0
2
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    int n, q;
    cin >> n >> q;
    for (int i = 0; i < n - 1; i++) {
        int a, b, r;
        cin >> a >> b >> r;
        g[a].push_back({ b, r }); // 双向加边
        g[b].push_back({ a, r });
    }
    for (int i = 0; i < q; i++) {
        int k, v;
        cin >> k >> v;
        cout << bfs(k, v) << endl;
    }

    return 0;
}