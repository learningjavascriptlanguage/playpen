#include <bits/stdc++.h>
using namespace std;

int n, k;
int pos[50001];

bool check(int mid) {
    int cnt = 0;
    int last = 0;  // 这一段中最左边的草堆位置
    while (last < n) {
        cnt++;
        int curr = last + 1;
        while (curr < n && pos[curr] - pos[last] <= 2 * mid) {
            curr++;
        }
        last = curr;
    }
    return cnt <= k;
}

int main() {
    freopen("angry.in", "r", stdin);
    freopen("angry.out", "w", stdout);

    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> pos[i];
    }
    sort(pos, pos + n);

    int left = 0;
    int right = pos[n - 1] - pos[0];
    int ans = right;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (check(mid)) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    cout << ans << endl;

    return 0;
}
