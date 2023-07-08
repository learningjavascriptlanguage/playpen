#include <bits/stdc++.h>
using namespace std;

int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};
int N, sx, sy;
int a[25][25], pow3[10], winning[19683],
    visited[19683 * 625], found[19683];
int ans;
char s[76];

int bit(int stat, int pos) {  // 井字棋中第pos个位置的值是多少
    return stat / pow3[pos] % 3;
}

int move(int stat, int dest) {
    if (dest == -1 || bit(stat, dest % 9)) { // 迷宫中为空地 或者 井字棋中该位置已有棋
        return stat;
    }
    return stat + (dest / 9 + 1) * pow3[dest % 9];
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        scanf("%s", s);
        for (int j = 0; j < N; j++) {
            if (s[j * 3] == '#') {
                a[i][j] = -2;
            }

            if (s[j * 3] == 'B') {
                sx = i;
                sy = j;
                a[i][j] = -1;
            }

            if (s[j * 3] == '.') {
                a[i][j] = -1;
            }

            if (s[j * 3] == 'O') {
                a[i][j] = (s[j * 3 + 1] - '1') * 3 + (s[j * 3 + 2] - '1');
            }

            if (s[j * 3] == 'M') {
                a[i][j] = 9 + (s[j * 3 + 1] - '1') * 3 + (s[j * 3 + 2] - '1');
            }
        }
    }

    pow3[0] = 1; // 3^0 ~ 3^9
    for (int i = 1; i <= 9; i++) {
		pow3[i] = pow3[i - 1] * 3;
	}

	// 预处理出， 3*3的?格的状态中，哪些是赢的状态
    for (int i = 0; i < pow3[9]; i++) {
        winning[i] = (bit(i, 0) == 2 && bit(i, 1) == 1 && bit(i, 2) == 1) ||
                     (bit(i, 3) == 2 && bit(i, 4) == 1 && bit(i, 5) == 1) ||
                     (bit(i, 6) == 2 && bit(i, 7) == 1 && bit(i, 8) == 1) ||
                     (bit(i, 2) == 2 && bit(i, 1) == 1 && bit(i, 0) == 1) ||
                     (bit(i, 5) == 2 && bit(i, 4) == 1 && bit(i, 3) == 1) ||
                     (bit(i, 8) == 2 && bit(i, 7) == 1 && bit(i, 6) == 1) ||
                     (bit(i, 0) == 2 && bit(i, 3) == 1 && bit(i, 6) == 1) ||
                     (bit(i, 1) == 2 && bit(i, 4) == 1 && bit(i, 7) == 1) ||
                     (bit(i, 2) == 2 && bit(i, 5) == 1 && bit(i, 8) == 1) ||
                     (bit(i, 6) == 2 && bit(i, 3) == 1 && bit(i, 0) == 1) ||
                     (bit(i, 7) == 2 && bit(i, 4) == 1 && bit(i, 1) == 1) ||
                     (bit(i, 8) == 2 && bit(i, 5) == 1 && bit(i, 2) == 1) ||
                     (bit(i, 0) == 2 && bit(i, 4) == 1 && bit(i, 8) == 1) ||
                     (bit(i, 8) == 2 && bit(i, 4) == 1 && bit(i, 0) == 1) ||
                     (bit(i, 2) == 2 && bit(i, 4) == 1 && bit(i, 6) == 1) ||
                     (bit(i, 6) == 2 && bit(i, 4) == 1 && bit(i, 2) == 1);
	}

	queue<int> q;
    q.push((sx * N + sy) * pow3[9]);
    visited[q.front()] = 1;
    while (!q.empty()) {
        int u = q.front();
		q.pop();
        if (winning[u % pow3[9]]) {
            found[u % pow3[9]] = 1;
            continue;
        }
        int x = u / pow3[9] / N;
		int y = u / pow3[9] % N;
		int us = u % pow3[9];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
            if (a[nx][ny] == -2) {
				continue;
			}
            int vs = move(us, a[nx][ny]);
            int v = (nx * N + ny) * pow3[9] + vs;
            if (!visited[v]) {
				q.push(v);
				visited[v] = 1;
			}
        }
    }
    for (int i = 0; i < pow3[9]; i++) {
		if (found[i]) ans++;
	}        
    printf("%d\n", ans);
    return 0;
}
