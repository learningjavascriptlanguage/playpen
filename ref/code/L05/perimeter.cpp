#include <bits/stdc++.h>
using namespace std;

struct point {
	int x, y;
};

bool icy[1001][1001], vis[1001][1001];
int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 方向数组
int n, areaMax = 0, p = INT_MAX;

void bfs(int i, int j) {
	queue<point> q;
	q.push({i, j});
    vis[i][j] = true;
    int area = 1, perimeter = 0;

    while(!q.empty()) {
        point cur = q.front();
        q.pop();
        for(int i=0; i<4;i++) { // 四个方向
        	//算出新的位置坐标
            int nx =  cur.x + dir[i][0];
            int ny =  cur.y + dir[i][1];
            //判断新的位置是否越界 或者 非冰激凌
            if(nx<1 || nx > n || ny < 1 || ny > n || !icy[nx][ny]) {
            	perimeter++;
            	continue;
			}

            // 已访问过 
            if(vis[nx][ny]) {
				continue;
			}

			q.push({nx, ny});
			vis[nx][ny] = true;
			area++;
		}
    }

    if(areaMax < area || areaMax == area && p > perimeter) {
    	areaMax = area;
    	p = perimeter;
	}
}

/*
6
##....
....#.
.#..#.
.#####
...###
....##

13 22
*/
int main() {
//	freopen("perimeter.in","r",stdin);
//	freopen("perimeter.out","w",stdout);
    ios::sync_with_stdio(false);
	cin.tie(0), cout.tie(0);
    cin>>n;
    
    for(int i=1; i<=n; i++) {
    	string s;
    	cin>>s;
    	for(int j=1; j<=n; j++) {
    		if(s[j-1] == '#') {
    			icy[i][j] = true;
			}
		}
	}
	
    for(int i=1; i<=n; i++) {
    	for(int j=1; j<=n; j++) {
    		if(icy[i][j] && !vis[i][j]) {
    			bfs(i, j);
			}
		}
	}

	cout<<areaMax<<" "<<p<<endl;

	return 0;
}
