#include <bits/stdc++.h>
#define ll long long
using namespace std;

const int MAXN = 2501;

int x[MAXN], y[MAXN];
int t[MAXN];
int p[MAXN][MAXN];
int prefix[MAXN][MAXN];
map<int, int> mx, my;

int rangesum(int x1, int y1, int x2, int y2) { // ���Ͻ�  ���½�
    return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
}

int arr[MAXN];
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
        cin>>x[i]>>y[i];

    for (int i = 1; i <= n; i++) {
        arr[i] = x[i];
    }        
    sort(arr + 1, arr + n + 1);
    for (int i = 1; i <= n; i++)
        mx[arr[i]] = i;
    for (int i = 1; i <= n; i++)
        x[i] = mx[x[i]];  // ��ɢ��

    for (int i = 1; i <= n; i++) {
        arr[i] = y[i];
    }
    sort(arr + 1, arr + n + 1);
    for (int i = 1; i <= n; i++)
        my[arr[i]] = i;
    for (int i = 1; i <= n; i++)
        y[i] = my[y[i]]; // ��ɢ��

    for (int i = 1; i <= n; i++)
    {
        t[x[i]] = y[i];
        p[x[i]][y[i]] = 1;
    }

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++) {
            // ��άǰ׺��
            prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + p[i][j];
        }

    ll ans = 1 + n; // �ռ� + ���㼯

    for (int i = 1; i <= n; i++) {  // ���϶˵�
        for (int j = i + 1; j <= n; j++)  // ���¶˵�
        {
            int yi = t[i], yj = t[j];
            if (yi > yj)
                swap(yi, yj);
            // �Ӽ�������
            ll left = rangesum(i, 1, j, yi - 1);
            // �Ӽ��Ҳ����
            ll right = rangesum(i, yj + 1, j, n);
            ans += (left + 1) * (right + 1); // ��άǰ׺���ҵ������м��������Ӽ���
        }
    }
    cout << ans << endl;

    return 0;
}