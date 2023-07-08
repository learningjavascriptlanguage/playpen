#include <bits/stdc++.h>
using namespace std;
int main()
{
    //freopen("div7.in", "r", stdin);
    //freopen("div7.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n; cin >> n;
    long long arr[50001] = { 0 };
    for (int i = 1; i <= n; i++) {
        int x; cin >> x;
        arr[i] = arr[i - 1];
        arr[i] += x;
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            if ((arr[j] - arr[i - 1]) % 7 == 0) ans = max(ans, j - i + 1);
        }
    }
    cout << ans << endl;
}


