#include <bits/stdc++.h>
using namespace std;

int n, k;
map<int, int> cnt;

const int N = 1e5 + 10;
int a[N];

int main() {
    scanf("%d %d", &n, &k);
    for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
    int l = 1;
    int ans = 0;
    for(int r=1; r<=n; r++) {
        cnt[a[r]]++;
        while (cnt.size() == k + 2) {
            cnt[a[l]]--;
            if (cnt[a[l]] == 0) cnt.erase(a[l]);
            l++;
        }
        ans = max(ans, cnt[a[r]]);
    }
    printf("%d\n", ans);
    return 0;
}
