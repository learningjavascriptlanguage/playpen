#include <bits/stdc++.h>
using namespace std;

const int DIR[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

int pasture[3500][3500];  // pasture[i][j] = 0:无牛  1:有牛
int cnt[3500][3500]; // cnt[i][j] (i, j)四周有几头牛
int ans = 0;

// function declaration
// TODO

void dfs(int x, int y) {
    // TODO
}

void add(int x, int y) {
    // TODO
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    int n, x, y;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> x >> y;
        x += 1000;
        y += 1000;
        if (pasture[x][y] > 0) {
            ans--;
        } else {
            add(x, y);
        }
        cout << ans << endl;
    }

    return 0;
}
