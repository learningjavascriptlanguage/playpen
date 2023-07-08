#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1e5 + 1;
int p1[MAXN], p2[MAXN], p3[MAXN];

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);

    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int n, q, t;
    cin >> n >> q;
    for (int i = 1; i <= n; i++) {
        cin >> t;
        p1[i] = p1[i - 1];
        p2[i] = p2[i - 1];
        p3[i] = p3[i - 1];
        if (t == 1) {
            p1[i]++;
        }

        if (t == 2) {
            p2[i]++;
        }

        if (t == 3) {
            p3[i]++;
        }
    }

    for (int i = 0; i < q; i++) {
        int a, b;
        cin >> a >> b;
        int cnt1 = p1[b] - p1[a - 1];
        int cnt2 = p2[b] - p2[a - 1];
        int cnt3 = p3[b] - p3[a - 1];
        cout << cnt1 << " " << cnt2 << " " << cnt3 << endl;
    }

    return 0;
}