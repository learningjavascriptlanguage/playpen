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
    int fx = find(x), fy = find(y);  //����������ŵ�ͬһ��ţȺ��
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
        vc[a[x]].push_back(x);  //��¼;����
        vc[a[y]].push_back(y);  //ͬ��
    }
    for (int i = 1; i <= n; i++) {
        vc[i].push_back(i);  //�������ǵ����
    }
    for (int i = 1; i <= n; i++) {
        merge(i, a[i]);  //����������ŵ�ͬһ��ţȺ��
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j < vc[a[i]].size(); j++) {
            ans[find(a[i])].insert(vc[a[i]][j]);  //ͳ��ÿ�����;�����ܹ��ж��ٸ�
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << ans[find(i)].size() << endl;  //��ͬ;����ĸ�������
    }
    return 0;
}