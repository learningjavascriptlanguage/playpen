#include <bits/stdc++.h>
using namespace std;
struct Node {
    int x, id;
} cows[50005];  //结构体

map<int, int> mp;          // stl中的map（映射）
set<int> s;
bool cmp(const Node &p, const Node &q) {
    return p.x < q.x;
}

int main() {
    int n, sum = 0, ans = INT_MAX;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%d%d", &cows[i].x, &cows[i].id);
        s.insert(cows[i].id);
    }
    sort(cows + 1, cows + n + 1, cmp);

    sum = s.size();  //计算奶牛种数
    int l = 1; // 区间左边界
    for (int r = 1; r <= n; r++) { // 区间右边界
        mp[cows[r].id]++;
        while (mp[cows[l].id] > 1) {  //去重
            mp[cows[l].id]--;         // 左端点右移一位
            l++;
        }
        if (mp.size() == sum)  // 照片中奶牛种数等于一共的奶牛种数
            ans = min(ans, cows[r].x - cows[l].x);
    }
    printf("%d\n", ans);
    return 0;
}
