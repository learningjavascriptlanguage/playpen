#include <bits/stdc++.h>
using namespace std;

int N, B, F[251], S[251], D[251], answer = INT_MAX;
bool vis[251][251];  // set of (location, boot) states we can reach

// recursively search through all reachable states
void dfs(int tileId, int bootId)  // 第tileId个tile, 目前穿着第bootId双靴子
{
    if (vis[tileId][bootId]) {
        return;    }

    vis[tileId][bootId] = true;

    if (tileId == N) {
        answer = min(answer, bootId - 1);   
        return;
    }

    // try all possible steps forward
    for (int j = 1; j <= D[bootId]; j++) {
        if (tileId + j <= N && F[tileId + j] <= S[bootId]) {
            dfs(tileId + j, bootId);
        }
    }

    // try all possible changes of boots
    for (int j = bootId + 1; j <= B; j++) {
        if (F[tileId] <= S[j]) {
            dfs(tileId, j);
        }
    }
}

int main() {
    //    freopen("snowboots.in", "r", stdin);
    //    freopen("snowboots.out", "w", stdout);

    cin >> N >> B;
    for (int i = 1; i <= N; i++) cin >> F[i];
    for (int i = 1; i <= B; i++) cin >> S[i] >> D[i];

    dfs(1, 1);
    cout << answer << endl;

    return 0;
}
