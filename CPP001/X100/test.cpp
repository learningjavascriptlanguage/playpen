#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int main() {
    int dirx[4] = { -1, 0, 1, 0 };
    int diry[4] = { 0, -1, 0, 1 };

    int n;
    cin >> n;
    int matrix[50][50];
    bool visited[50][50];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
            visited[i][j] = false;
        }
    }

    int minpath = 2500, mincount = 0;
    queue< tuple< int, int, int > > bfsq;
    bfsq.push({ 0, 0, 1 });
    while (!bfsq.empty()) {
        int x, y, path;
        tie(x, y, path) = bfsq.front();
        bfsq.pop();

        if (x == n - 1 && y == n - 1) {
            if (path < minpath) {
                minpath = path;
                mincount = 1;
            }
            else if (path == minpath) {
                mincount++;
            }
        }

        for (int i = 0; i < 4; i++) {
            int newx = x + dirx[i];
            int newy = y + diry[i];
            if (newx >= 0 && newx < n && newy >= 0 && newy < n && matrix[newx][newy] == 0 && !visited[newx][newy]) {
                bfsq.push({ newx, newy, path + 1 });
                visited[newx][newy] = true;
            }
        }
    }

    cout << mincount << "\n" << minpath << "\n";
}