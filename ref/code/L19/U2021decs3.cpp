#include <bits/stdc++.h>
using namespace std;

const int MAXK = 1e4 + 1;
long long l[MAXK], r[MAXK], prefix[MAXK];
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        int a, b;
        cin >> a >> b;
        //统计每个点作为左右边界的次数
        l[a]++;
        r[b]++;
    }

    for (int a = 0; a <= m; a++)
        for (int b = 0; b <= m; b++) {
            //计算i和j作为左边界的ai+aj<=k的数量,加上去，作为右边界的bi+bj<k的数量,减掉
            prefix[a + b] += l[a] * l[b];
            prefix[a + b + 1] -= r[a] * r[b];
        }

    // 计算prefix[k]
    cout << prefix[0] << endl;
    for (int i = 1; i <= 2 * m; i++) {
        prefix[i] += prefix[i - 1];  //通过计算前缀和，把k=i的时候有多少集合满足ai+aj<=k<=bi+bj算出来
        cout << prefix[i] << endl;
    }
}
/*
2 5
1 3
2 5
*/
