#include <bits/stdc++.h>
using namespace std;

const int MAXN = 40005;
int B, E, P, N, M, ans = INT_MAX;
int disB[MAXN], disE[MAXN], disN[MAXN];
vector<int> g[MAXN];

void bfs(int start, int dis[]) {
    bool vis[MAXN] = {};
    queue<int> q;
    q.push(start);
    vis[start] = true;
    dis[start] = 0;
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (auto to : g[cur]) {
            if (vis[to]) continue;
            q.push(to);
            vis[to] = true;
            dis[to] = dis[cur] + 1;
        }
    }
}

int main() {
    //    freopen("piggyback.in","r",stdin);
    //    freopen("piggyback.out","w",stdout);
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> B >> E >> P >> N >> M;
    for (int i = 0; i < M; i++) {
        int from, to;
        cin >> from >> to;
        g[from].push_back(to);
        g[to].push_back(from);
    }

    bfs(1, disB);
    bfs(2, disE);
    bfs(N, disN);

    for (int i = 1; i <= N; i++) {
        ans = min(ans, disB[i] * B + disE[i] * E + disN[i] * P);
    }
    cout << ans << endl;

    return 0;
}