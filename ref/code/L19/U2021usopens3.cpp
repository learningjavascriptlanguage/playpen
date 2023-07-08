#include <bits/stdc++.h>
using namespace std;
int N, a[100001], K, L;

bool check(int mid) {
    long long sum = 0;
    for (int i = 1; i <= mid; i++) {
        if (mid - a[i] > K) {
            return false;
        }
        sum += max(0, mid - a[i]);
    }

    return sum <= 1LL * K * L;
}

int main() {
    scanf("%d%d%d", &N, &K, &L);
    for (int i = 1; i <= N; i++) {
		scanf("%d", a + i);
	}
    sort(a + 1, a + N + 1, greater<int>()); // 从大到小排序
    int l = 0, r = N;
    int ans = 0;
    while (l <= r) {
        int mid = (l + r) / 2; //  l + r >> 1
        if (check(mid)) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    printf("%d\n", ans);
    return 0;
}
