#include <bits/stdc++.h>
using namespace std;

int a[100001];
int pre1[100001], pre2[100001], pre3[100001];
int main() {
    //freopen("div7.in", "r", stdin);
    //freopen("div7.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);

    int n, q;
    cin >> n >> q;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        pre1[i] = pre1[i - 1];
        pre2[i] = pre2[i - 1];
        pre3[i] = pre3[i - 1];
        if (a[i] == 1) {
            pre1[i]++;
        }
        if (a[i] == 2) {
            pre2[i]++;
        }
        if (a[i] == 3) {
            pre3[i]++;
        }
    }
    int x, y;
    for (int i = 1; i <= q; i++) {
        cin >> x >> y;
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        cnt1 = pre1[y] - pre1[x - 1];
        cnt2 = pre2[y] - pre2[x - 1];
        cnt3 = pre3[y] - pre3[x - 1];
        cout << cnt1 << " " << cnt2 << " " << cnt3 << endl;
    }


    /*for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    int x, y;
    for (int i = 1; i <= q; i++) {
        cin >> x >> y;
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for (int j = x; j <= y; j++) {
            if (a[j] == 1) {
                cnt1++;
            }
            else if (a[j] == 2) {
                cnt2++;
            }
            else if (a[j] == 3) {
                cnt3++;
            }
        }
        cout << cnt1 << " " << cnt2 << " " << cnt3 << endl;
   }*/ //Time out



}