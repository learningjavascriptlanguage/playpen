#include <bits/stdc++.h>
using namespace std;

int a[1001];
int r[1001];

int main() {
    // freopen("berries.in","r",stdin);
    // freopen("berries.out","w",stdout);

    int n, k;
    cin >> n >> k;
    int maxa = 0;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        maxa = max(maxa, a[i]);
    }

    int answer = 0;
    for (int i = 1; i <= maxa; i++) {  // i为第K/2个篮子中果子数量
        int cnt = 0;                   // 装有i个果子的篮子数量
        for (int j = 1; j <= n; j++) {
            cnt += a[j] / i;
            r[j] = a[j] % i;  // 存零头
        }
        sort(r + 1, r + 1 + n, greater<int>());  // 把零头从大到小排序
        if (cnt >= k) {
            answer = max(answer, k / 2 * i);
        } else if (cnt >= k / 2) {
            int temp = cnt - k / 2;
            temp *= i;
            for (int j = 1; j <= min(n, k - cnt); j++) {
                temp += r[j];
            }
            answer = max(answer, temp);
        }
    }

    cout << answer << endl;

    return 0;
}
