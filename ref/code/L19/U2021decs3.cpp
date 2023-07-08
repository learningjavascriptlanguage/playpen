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
        //ͳ��ÿ������Ϊ���ұ߽�Ĵ���
        l[a]++;
        r[b]++;
    }

    for (int a = 0; a <= m; a++)
        for (int b = 0; b <= m; b++) {
            //����i��j��Ϊ��߽��ai+aj<=k������,����ȥ����Ϊ�ұ߽��bi+bj<k������,����
            prefix[a + b] += l[a] * l[b];
            prefix[a + b + 1] -= r[a] * r[b];
        }

    // ����prefix[k]
    cout << prefix[0] << endl;
    for (int i = 1; i <= 2 * m; i++) {
        prefix[i] += prefix[i - 1];  //ͨ������ǰ׺�ͣ���k=i��ʱ���ж��ټ�������ai+aj<=k<=bi+bj�����
        cout << prefix[i] << endl;
    }
}
/*
2 5
1 3
2 5
*/
