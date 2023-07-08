#include <bits/stdc++.h>
#define LL long long
using namespace std;

LL n, k, m;

bool check(LL x) {
    LL g = 0, leftDays = k;
    while (leftDays > 0) {
        LL y = (n - g) / x;
        if (y <= m) {  // 优化1
            g += leftDays * m;
            return g >= n;
        }

        // 优化2
        LL cnt = min(leftDays, (n - g) % x / y + 1);
        g += y * cnt;
        leftDays -= cnt;
        if(g >= n) return true;
    }

    return false;
}

int main() {
    freopen("loan.in", "r", stdin);
    freopen("loan.out", "w", stdout);

    cin >> n >> k >> m;
    LL left = 1, right = n, answer = 0;
    while (left <= right) {
        LL mid = (left + right) / 2;
        if (check(mid)) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    cout << answer << endl;

    return 0;
}
