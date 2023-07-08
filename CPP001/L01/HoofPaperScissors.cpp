#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 1;
int h[N], p[N], s[N];
int main()
{
    //freopen("div7.in", "r", stdin);
    //freopen("div7.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n;
    char t;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> t;
        h[i] = h[i - 1];
        p[i] = p[i - 1];
        s[i] = s[i - 1];
        if (t == 'H') h[i]++;
        if (t == 'S') s[i]++;
        if (t == 'P') p[i]++;
    }
    int ans = -1;
    for (int i = 1; i <= n; i++) {
        int cnt1 = max(p[i], max(h[i], s[i]));
        int cnt2 = max(p[n] - p[i], max(h[n] - h[i], s[n] - s[i]));
        int sum = cnt1 + cnt2;
        ans = max(ans, sum);
    }

    cout << ans << endl;
    return 0;

}