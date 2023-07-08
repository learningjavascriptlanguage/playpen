#include <bits/stdc++.h>
using namespace std;
int deg[100010];

int calDouble(int num) {
    int i = 0;
    while ((1 << i) < num) {
        i++;
    }
    return i;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i < n; i++) {
        int a, b;
        cin >> a >> b;
        deg[a]++;
        deg[b]++;
    }

    deg[1]++;  // 1号点为根节点，没有父亲节点过来的牛
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (deg[i] != 1) {             // 非叶子节点
            ans += calDouble(deg[i]);  // 计算需要翻倍的次数(event1)
        }
    }

    cout << ans + n - 1 << endl;  // 除了根节点以外，其他节点都需要从父亲节点移动一头牛过来,
                                  // 需要加上n-1(event2)
    return 0;
}