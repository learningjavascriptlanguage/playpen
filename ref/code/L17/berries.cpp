#include <bits/stdc++.h>
using namespace std;

int a[1001];
int r[1001];

int main() {
    // freopen("berries.in","r",stdin);
    // freopen("berries.out","w",stdout);

    int n, k;
    cin >> n >> k;
    int maxa = 0;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        maxa = max(maxa, a[i]);
    }

    int answer = 0;
    for (int i = 1; i <= maxa; i++) {  // iΪ��K/2�������й�������
        int cnt = 0;                   // װ��i�����ӵ���������
        for (int j = 1; j <= n; j++) {
            cnt += a[j] / i;
            r[j] = a[j] % i;  // ����ͷ
        }
        sort(r + 1, r + 1 + n, greater<int>());  // ����ͷ�Ӵ�С����
        if (cnt >= k) {
            answer = max(answer, k / 2 * i);
        } else if (cnt >= k / 2) {
            int temp = cnt - k / 2;
            temp *= i;
            for (int j = 1; j <= min(n, k - cnt); j++) {
                temp += r[j];
            }
            answer = max(answer, temp);
        }
    }

    cout << answer << endl;

    return 0;
}
