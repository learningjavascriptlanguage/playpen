#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1e5+1;
long long c[MAXN];
int main() {
    //freopen("div7.in", "r", stdin);
    //freopen("div7.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) { 
        cin >> c[i];
    }
    sort(c, c + n); //学费从小到大排序，依次算总收学费是否最大

    long long maxMoney = 0, bestTuition = 0;
    int CowCount = n;
    for (int i = 0; i < n; i++) {
        long long totalTuition = c[i] * CowCount;
        if (totalTuition > maxMoney) {
            maxMoney = totalTuition;
            bestTuition = c[i];
        }
        CowCount--;
    }

    cout << maxMoney << " " << bestTuition << endl;

    return 0;
}