#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, k;
int a[N];
int fa[N];

int find(int x) {
    if (fa[x] == x) return x;
    return fa[x] = find(fa[x]);
}

void merge(int x, int y) {
    int fx = find(x), fy = find(y);  //把这两个点放到同一个牛群中
    if(fx != fy) {
        fa[fy] = fx;
    }    
}

vector<int> vc[N];
int cx[N], cy[N];
set<int> ans[N];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        fa[i] = i;
        a[i] = i;
    }
    
    for (int i = 1; i <= k; i++) {
        int x, y;
        cin>>x>>y;

        swap(a[x], a[y]);
        vc[a[x]].push_back(x);  //记录途径点
        vc[a[y]].push_back(y);  //同上
    }
    for (int i = 1; i <= n; i++) {
        vc[i].push_back(i);  //加上他们的起点
    }
    for (int i = 1; i <= n; i++) {
        merge(i, a[i]);  //把这两个点放到同一个牛群中
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < vc[a[i]].size(); j++) {
            ans[find(a[i])].insert(vc[a[i]][j]);  //统计每个点的途径点总共有多少个
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << ans[find(i)].size() << endl;  //不同途径点的个数即答案
    }
    return 0;
}