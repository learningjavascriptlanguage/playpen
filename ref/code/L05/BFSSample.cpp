#include<bits/stdc++.h>
using namespace std;

struct point {
    int x, y, s; // �У��У����� 
};

queue<point> q;
int maze[51][51];
bool vis[51][51];
int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // ��������

/*
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
    int row, col;
    cin>>row>>col;
    for(int i=1; i<=row; i++) {
        for(int j=1; j<=col; j++) {
            cin>>maze[i][j];
        }
    }
    int sx, sy, ex, ey;
    cin>>sx>>sy>>ex>>ey;

    q.push({sx, sy, 0}); // ����֮��, ������ԭ
    vis[sx][sy] = true;

    while(!q.empty()) {
    	// ȡ�����׵ĵ�
        point cur = q.front();
        q.pop();
        for(int i=0; i<4; i++) {
        	//����µ�λ������ 
            int nx = cur.x + dir[i][0];
            int ny = cur.y + dir[i][1];
            //�ж��µ�λ���Ƿ�Խ��
            if(nx<1 || nx > row || ny < 1 || ny > col)
                continue;
            // ����µ�λ�����ϰ� ���� ���߹�
            if(maze[nx][ny]==1 || vis[nx][ny]) {
            	continue;
            }
            // ����λ�ü������
            q.push({nx, ny, cur.s + 1});
            vis[nx][ny] = true;

            if(nx == ex && ny == ey) {
                cout<<q.back().s<<endl;
                return 0;
            }
         }
    }

    cout<<-1<<endl;

    return 0;
}
