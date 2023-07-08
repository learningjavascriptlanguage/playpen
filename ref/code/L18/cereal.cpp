#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1e5 + 1;
const int MAXM = 1e5 + 1;
int n, m;
int cow[MAXN][2];
int food[MAXM];  // 记录第i种食物被哪头牛拿走
int cnt;
int answer[MAXN];

void chooseFood(int cowId) {
    int food1 = cow[cowId][0];
    int contestedCowId = food[food1];
    if (contestedCowId == 0) {
        food[food1] = cowId;
        return;
    }
    if (contestedCowId < cowId) {
        int food2 = cow[cowId][1];
        contestedCowId = food[food2];
        if (contestedCowId == 0) {
            food[food2] = cowId;
            return;
        }
        if (contestedCowId < cowId) {
            cnt--;
            return;
        } else {
            food[food2] = cowId;
            chooseFood(contestedCowId);
        }
    } else {
        food[food1] = cowId;
        chooseFood(contestedCowId);
    }
}

int main() {
    // freopen("cereal.in", "r", stdin);
    // freopen("cereal.out", "w", stdout);
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) {
        scanf("%d%d", &cow[i][0], &cow[i][1]);
    }

    for (int i = n; i >= 1; i--) {
        cnt++;
        chooseFood(i);
        answer[i] = cnt;
    }

    for (int i = 1; i <= n; i++) {
        cout << answer[i] << endl;
    }

    return 0;
}
