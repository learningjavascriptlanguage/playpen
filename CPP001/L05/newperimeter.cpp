#include <bits/stdc++.h>
using namespace std;
struct point {
    int x, y;
};

bool ice[1001][1001], visit[1001][1001];
int dir[4][2] = { {1,0}, {0,1}, {-1,0}, {0,-1} }; //directions
int n;
int maxarea = 0, p = INT_MAX;

void bfs(int i, int j) {
    queue<point> q;
    q.push({ i,j });
    visit[i][j] = true;
    int area = 1, perimeter = 0;
    while (!q.empty()) {
        point cur = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) { //check for 4 directions
            int nx = cur.x + dir[i][0];
            int ny = cur.y + dir[i][1];
            if (nx < 1 or nx > n or ny < 1 or ny > n or !ice[nx][ny]) { //if there's no ice around current position (boundary counts too)
                perimeter++;
                continue;
            }
            if (visit[nx][ny]) continue; //however already visited places don't count towards perimeter
            q.push({ nx, ny });
            visit[nx][ny] = true;
            area++;
        }
        if (maxarea < area or maxarea == area and p > perimeter) {
            maxarea = area;
            p = perimeter;
        }
    }
}

int main() {
    //freopen("perimeter.in", "r", stdin);
    //freopen("perimeter.out", "w", stdout);
    ios::sync_with_stdio;
    cin.tie(0), cout.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++) {
        string s; cin >> s;
        for (int j = 1; j <= n; j++) {
            if (s[j - 1] == '#') { //j - 1 because of 1 indexing instead of 0
                ice[i][j] = true;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (ice[i][j] and !visit[i][j]) //if there's ice and it has not been visited
                bfs(i, j);
        }
    }
    cout << maxarea << " " << p << endl;
}