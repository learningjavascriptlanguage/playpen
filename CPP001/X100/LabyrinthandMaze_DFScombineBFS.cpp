#include <bits/stdc++.h>
using namespace std;

int row, col, ex, ey;
int maze[51][51];
bool vis[51][51];  // 记录当前的搜索路径中已包含哪些点
bool visbfs[51][51];
int minn = INT_MAX;
int paths = 1;
int shortest_len = INT_MAX;

// 方向数组
const int DIR[4][2] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
struct point {
    int x, y, s; // 行，列，步数 
};

void dfs(int x, int y, int step) {
    // 判断是否到终点
    if (x == ex && y == ey) {
        minn = min(minn, step);
        if (minn == shortest_len) {
            paths++;
        }
        else if (minn < shortest_len) {
            shortest_len = minn;
            paths = 1;
        }
       // cout << paths << endl;
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

int bfs(int maze[51][51]) {
    queue<point> q;
    q.push({ 1, 1, 1 }); // 星星之火, 可以燎原
    visbfs[1][1] = true;

    while (!q.empty()) {
        // 取出队首的点
        point cur = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            //算出新的位置坐标 
            int nx = cur.x + DIR[i][0];
            int ny = cur.y + DIR[i][1];
            //判断新的位置是否越界
            if (nx<1 || nx > row || ny < 1 || ny > col)
                continue;
            // 如果新的位置是障碍 或者 已走过
            if (maze[nx][ny] == 1 || visbfs[nx][ny]) {
                continue;
            }
            // 把新位置加入队列
            q.push({ nx, ny, cur.s + 1 });
            visbfs[nx][ny] = true;

            if (nx == ex && ny == ey) {
                cout << q.back().s << endl;
                return 0;
            }
        }
    }

    cout << -1 << endl;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int sx, sy;
    cin >> row;
    col = row;
    // 读入迷宫
    for (int i = 1; i <= row; i++)
        for (int j = 1; j <= col; j++) cin >> maze[i][j];
    sx = sy = 1;
    ex = ey = row;
    vis[sx][sy] = true;
    //bfs(maze);
    dfs(sx, sy, 1);
    cout << paths << endl;
    cout << minn << endl;


    return 0;
}
