#include <bits/stdc++.h>
using namespace std;

int N, a[1001][1001], max1, max2;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++) {
            cin >> a[i][j];
        }

    for (int i = 1; i <= N; i++) {
        int odd = 0, even = 0;
        for (int j = 1; j <= N; j++) {
            if (j % 2 == 1) {
                odd += a[i][j];
            } else {
                even += a[i][j];
            }
        }
        max1 += max(odd, even);

        odd = 0, even = 0;
        for (int j = 1; j <= N; j++) {
            if (j % 2 == 1) {
                odd += a[j][i];
            } else {
                even += a[j][i];
            }
        }
        max2 += max(odd, even);
    }

    cout << max(max1, max2) << endl;
    return 0;
}
