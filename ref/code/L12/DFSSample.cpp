#include <bits/stdc++.h>
using namespace std;

int row, col, ex, ey;
int maze[51][51];
bool vis[51][51];  // ��¼��ǰ������·�����Ѱ�����Щ��
int minn = INT_MAX;

// ��������
const int DIR[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

void dfs(int x, int y, int step) {
    // �ж��Ƿ��յ�
    if (x == ex && y == ey) {
        minn = min(minn, step);
        return;
    }
    // ��֦ prune
    if (step >= minn) {
        return;
    }
    // ö��ÿһ������
    for (int i = 0; i < 4; i++) {
        //������һ�����λ��
        int nx = x + DIR[i][0];
        int ny = y + DIR[i][1];

        // �ж��Ƿ�Խ��
        if (nx < 1 || nx > row || ny < 1 || ny > col) continue;

        // �ϰ��� ���� �ѷ��ʹ�
        if (maze[nx][ny] == 1 || vis[nx][ny]) continue;

        vis[nx][ny] = true;
        dfs(nx, ny, step + 1);
        vis[nx][ny] = false;  // ����
    }
}

/*
����
5 4
0 0 1 0
0 0 0 0
0 0 1 0
0 1 0 0
0 0 0 1
1 1 4 3

���
7
*/
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int sx, sy;
    cin >> row >> col;
    // �����Թ�
    for (int i = 1; i <= row; i++)
        for (int j = 1; j <= col; j++) cin >> maze[i][j];

    cin >> sx >> sy >> ex >> ey;
    vis[sx][sy] = true;
    dfs(sx, sy, 0);
    cout << minn << endl;

    return 0;
}
