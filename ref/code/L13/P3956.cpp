#include <bits/stdc++.h>
using namespace std;

int board[101][101];    // �������̣���¼ÿ������ɫ���
int minCoin[101][101];  // ��֦������ÿ��λ�û�����С�Ľ����
bool vis[101][101];     //����ÿ��λ���Ƿ����
int dx[4] = {0, 0, 1, -1},
    dy[4] = {1, -1, 0, 0};  //�ĸ��������򣬷ֱ��ʾ��������仯ֵ
int ans = INT_MAX;
int m, n;

// x��yΪ��ǰλ������ ��cΪ��ǰ������ң�colorΪ��ǰλ����ɫ
void dfs(int x, int y, int c, int color) {
    if (c >= minCoin[x][y]) {  // �����Լ�֦
        return;
    }
    minCoin[x][y] = c;  //��������λ�õ���С����

    if (x == m && y == m) {  //�����½�
        ans = min(c, ans);   //��ans��(m,m)����С����
        return;
    }

    for (int i = 0; i < 4; i++) {  //���ĸ���������
        int nx = x + dx[i];        //�ƶ��󵽴��λ��
        int ny = y + dy[i];
        if (nx < 1 || nx > m || ny < 1 || ny > m) {  //�ж�����λ���Ƿ�Խ��
            continue;
        }

        if (vis[nx][ny]) {  //�ж�����λ���Ƿ��߹�
            continue;
        }

        //�ж�����λ�ú͵�ǰλ���Ƿ���͸��ɫ
        if (board[x][y] == 0 && board[nx][ny] == 0) {
            continue;
        }

        vis[nx][ny] = true;  //����λ����Ϊ����
        // ��λ������ɫ
        if (board[nx][ny] != 0) {
            // ǰ����ɫ��ͬ
            if (color == board[nx][ny]) { // !!! �˴���color
                dfs(nx, ny, c, board[nx][ny]);  // �����ݹ�
            } else {  // ǰ����ɫ��ͬ
                dfs(nx, ny, c + 1, board[nx][ny]);
            }
        } else {
            // ��λ������ɫ
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
        board[x][y] = c + 1;  // c=2 �����ɫ�� c=1 �����ɫ  c=0 ͸��
    }

    vis[1][1] = true;
    dfs(1, 1, 0, board[1][1]);
    if (ans == INT_MAX)
        cout << -1 << endl;  //û���ҵ����-1
    else
        cout << ans << endl;

    return 0;
}
