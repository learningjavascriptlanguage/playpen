#include<bits/stdc++.h>
using namespace std;

struct point {
    int x, y, s; // 行，列，步数 
};

queue<point> q;
int maze[51][51];
int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 方向数组 
bool vis[51][51];

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
    int row, col;
    cin>>row>>col;
    for(int i=1; i<=row; i++) {
        for(int j=1; j<=col; j++) {
            cin>>maze[i][j];
        }
    }
    int sx, sy, ex, ey;
    cin>>sx>>sy>>ex>>ey;

    q.push({sx, sy, 0}); // 星星之火, 可以燎原
    vis[sx][sy] = true;

    while(!q.empty()) {
        // 取出队首的点 
        
        for(int i=0; i<4;i++) {
        	//算出新的位置坐标 
            
            //判断新的位置是否越界 
           
            // 如果新的位置是障碍 或者 已走过
            
            // 把新位置加入队列

            // 新的位置是否为终点
        }
    }
    cout<<-1<<endl;

    return 0;
}
