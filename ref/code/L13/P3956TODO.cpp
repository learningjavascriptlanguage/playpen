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
    if (x == m && y == m) {  //最右下角
        ans = min(c, ans);   //用ans到(m,m)的最小花费
        return;
    }

    // 最优性剪枝
    // TODO

    for (int i = 0; i < 4; i++) {  //向四个方向搜索
        int nx = x + dx[i];        //移动后到达的位置
        int ny = y + dy[i];
        // TODO
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
