#include <bits/stdc++.h>
using namespace std;

int a[10], cnt, n;
bool vis[1000];
int ans[10];

void dfs(int pos) {
    if (pos == n + 1) {
        cnt++;
        for (int i = 1; i <= n; i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (!vis[a[i]]) {
            ans[pos] = a[i];
            vis[a[i]] = true;
            dfs(pos + 1);
            vis[a[i]] = false; // back trace
        }
    }
}

int main() {
    cin >> n;
    for(int i=1; i<=n; i++) {
        cin>>a[i];
    }
    dfs(1);
    cout << cnt << endl;
    return 0;
}