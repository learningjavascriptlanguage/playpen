#include<bits/stdc++.h>
using namespace std;

struct point {
    int x, y, s; // �У��У����� 
};

queue<point> q;
int maze[51][51];
int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // �������� 
bool vis[51][51];

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
        
        for(int i=0; i<4;i++) {
        	//����µ�λ������ 
            
            //�ж��µ�λ���Ƿ�Խ�� 
           
            // ����µ�λ�����ϰ� ���� ���߹�
            
            // ����λ�ü������

            // �µ�λ���Ƿ�Ϊ�յ�
        }
    }
    cout<<-1<<endl;

    return 0;
}
