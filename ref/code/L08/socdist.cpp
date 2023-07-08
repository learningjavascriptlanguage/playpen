#include <bits/stdc++.h>
#define LL long long
using namespace std;

struct interval {
    LL start, end;
};

int N, M;
interval p[100001];

bool cmp(const interval &a, const interval &b) { 
	return a.start < b.start;
}

bool check(LL mid) {
    LL cnt = 0, begin = 0;
    for (int i = 1; i <= M; i++) {
        begin = max(begin, p[i].start);
        if (begin <= p[i].end) {
            LL points = (p[i].end - begin) / mid + 1;
            cnt += points;
            begin += points * mid;
        }
    }

    return cnt >= N;
}

int main() {
    // freopen("socdist.in", "r", stdin);
    // freopen("socdist.out", "w", stdout);
    scanf("%d%d", &N, &M);

    for (int i = 1; i <= M; i++) {
        scanf("%lld%lld", &p[i].start, &p[i].end);
    }

    sort(p + 1, p + M + 1, cmp);
    LL l = 1, r = p[M].end, ans;
    while (l <= r) {
        LL mid = (l + r) / 2;

        if (check(mid)) {
            l = mid + 1;
            ans = mid;
        } else {
            r = mid - 1;
        }
    }
    printf("%lld\n", ans);
    return 0;
}
