#include <bits/stdc++.h>
using namespace std;

int board[101][101];    // 保存棋盘，记录每个点颜色情况
int minCoin[101][101];  // 剪枝：保存每个位置花费最小的金币数
bool vis[101][101];     //保存每个位置是否可走
int dx[4] = {0, 0, 1, -1},
    dy[4] = {1, -1, 0, 0};  //四个搜索方向，分别表示横纵坐标变化值
int ans = INT_MAX;
int m, n;

// x，y为当前位置坐标 ，c为当前所花金币，color为当前位置颜色
void dfs(int x, int y, int c, int color) {
    if (c >= minCoin[x][y]) {  // 最优性剪枝
        return;
    }
    minCoin[x][y] = c;  //更新搜索位置的最小花费

    if (x == m && y == m) {  //最右下角
        ans = min(c, ans);   //用ans到(m,m)的最小花费
        return;
    }

    for (int i = 0; i < 4; i++) {  //向四个方向搜索
        int nx = x + dx[i];        //移动后到达的位置
        int ny = y + dy[i];
        if (nx < 1 || nx > m || ny < 1 || ny > m) {  //判断搜索位置是否越界
            continue;
        }

        if (vis[nx][ny]) {  //判断搜索位置是否走过
            continue;
        }

        //判断搜索位置和当前位置是否都是透明色
        if (board[x][y] == 0 && board[nx][ny] == 0) {
            continue;
        }

        vis[nx][ny] = true;  //将此位置设为已走
        // 新位置有颜色
        if (board[nx][ny] != 0) {
            // 前后颜色相同
            if (color == board[nx][ny]) { // !!! 此处用color
                dfs(nx, ny, c, board[nx][ny]);  // 继续递归
            } else {  // 前后颜色不同
                dfs(nx, ny, c + 1, board[nx][ny]);
            }
        } else {
            // 新位置无颜色
            dfs(nx, ny, c + 2, color);
        }
        vis[nx][ny] = false;
    }
}

int main() {
    //	freopen("chess.in","r",stdin);
    //  freopen("chess.out","w",stdout);
    cin >> m >> n;
    memset(minCoin, 0x7f, sizeof(minCoin));

    for (int i = 1; i <= n; i++) {
        int x, y, c;
        scanf("%d%d%d", &x, &y, &c);
        board[x][y] = c + 1;  // c=2 代表黄色， c=1 代表红色  c=0 透明
    }

    vis[1][1] = true;
    dfs(1, 1, 0, board[1][1]);
    if (ans == INT_MAX)
        cout << -1 << endl;  //没有找到输出-1
    else
        cout << ans << endl;

    return 0;
}
