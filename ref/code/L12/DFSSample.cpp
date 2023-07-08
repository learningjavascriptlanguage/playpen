#include <bits/stdc++.h>
using namespace std;

int row, col, ex, ey;
int maze[51][51];
bool vis[51][51];  // 记录当前的搜索路径中已包含哪些点
int minn = INT_MAX;

// 方向数组
const int DIR[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

void dfs(int x, int y, int step) {
    // 判断是否到终点
    if (x == ex && y == ey) {
        minn = min(minn, step);
        return;
    }
    // 剪枝 prune
    if (step >= minn) {
        return;
    }
    // 枚举每一个方向
    for (int i = 0; i < 4; i++) {
        //计算下一个点的位置
        int nx = x + DIR[i][0];
        int ny = y + DIR[i][1];

        // 判断是否越界
        if (nx < 1 || nx > row || ny < 1 || ny > col) continue;

        // 障碍物 或者 已访问过
        if (maze[nx][ny] == 1 || vis[nx][ny]) continue;

        vis[nx][ny] = true;
        dfs(nx, ny, step + 1);
        vis[nx][ny] = false;  // 回溯
    }
}

/*
输入
5 4
0 0 1 0
0 0 0 0
0 0 1 0
0 1 0 0
0 0 0 1
1 1 4 3

输出
7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int sx, sy;
    cin >> row >> col;
    // 读入迷宫
    for (int i = 1; i <= row; i++)
        for (int j = 1; j <= col; j++) cin >> maze[i][j];

    cin >> sx >> sy >> ex >> ey;
    vis[sx][sy] = true;
    dfs(sx, sy, 0);
    cout << minn << endl;

    return 0;
}
