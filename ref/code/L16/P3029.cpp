#include <bits/stdc++.h>
using namespace std;
struct Node {
    int x, id;
} cows[50005];  //�ṹ��

map<int, int> mp;          // stl�е�map��ӳ�䣩
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

    sum = s.size();  //������ţ����
    int l = 1; // ������߽�
    for (int r = 1; r <= n; r++) { // �����ұ߽�
        mp[cows[r].id]++;
        while (mp[cows[l].id] > 1) {  //ȥ��
            mp[cows[l].id]--;         // ��˵�����һλ
            l++;
        }
        if (mp.size() == sum)  // ��Ƭ����ţ��������һ������ţ����
            ans = min(ans, cows[r].x - cows[l].x);
    }
    printf("%d\n", ans);
    return 0;
}
