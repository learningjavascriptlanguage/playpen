#include <bits/stdc++.h>
#define ll long long
using namespace std;

const int MAXN = 1e5 + 1;

struct reststop {
    int x, c;
};
int L, N;
ll rf, rb;
reststop st[MAXN];
bool isMax[MAXN];
int main() {
    cin >> L >> N >> rf >> rb;
    for (int i = 0; i < N; i++) {
        cin >> st[i].x >> st[i].c;
    }
    int maxc = 0;
    for (int i = N - 1; i >= 0; i--) {
        if (st[i].c > maxc) {
            isMax[i] = true;
            maxc = st[i].c;
        }
    }
    ll ans = 0, lastx = 0;
    for (int i = 0; i < N; i++) {
        if (isMax[i]) {
            ll t = (st[i].x - lastx) * (rf - rb);
            ans += t * st[i].c;
            lastx = st[i].x;
        }
    }
    cout << ans << endl;
    return 0;
}
