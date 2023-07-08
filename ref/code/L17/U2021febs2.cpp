#include <bits/stdc++.h>
using namespace std;

set<int> s;
int a[100010], interval[100010];
int main() {
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        int t;
        scanf("%d", &t);
        s.insert((t+11)/12);
    }
    set<int>::iterator itr = s.begin();
    int cnt = 0;
    while (itr != s.end()) {
        a[cnt] = *itr;
        cnt++;
        itr++;
    }

    interval[0] = a[0] - 1;  // 和起点的间隔
    for (int i = 1; i < cnt; i++) {
        interval[i] = a[i] - a[i - 1] - 1;
    }
    
    int saved = 0;
    sort(interval, interval + cnt, greater<int>());
    for (int i = 0; i < k - 1; i++) {
        saved += interval[i];
    }
    cout<<saved<<endl;
    cout << (a[cnt - 1] - saved) * 12 << endl;

    return 0;
}