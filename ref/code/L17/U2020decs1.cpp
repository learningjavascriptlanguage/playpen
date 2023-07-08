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

    deg[1]++;  // 1�ŵ�Ϊ���ڵ㣬û�и��׽ڵ������ţ
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (deg[i] != 1) {             // ��Ҷ�ӽڵ�
            ans += calDouble(deg[i]);  // ������Ҫ�����Ĵ���(event1)
        }
    }

    cout << ans + n - 1 << endl;  // ���˸��ڵ����⣬�����ڵ㶼��Ҫ�Ӹ��׽ڵ��ƶ�һͷţ����,
                                  // ��Ҫ����n-1(event2)
    return 0;
}