#include <bits/stdc++.h>
using namespace std;
int TC, N, cnt;
long long a[7], can[1000];

int main() {
    scanf("%d", &TC);
    while (TC--) {
        scanf("%d", &N);
        for (int i = 0; i < N; i++) {
            scanf("%lld", a + i);
        }
        cnt = 0;
        for (int i = 0; i < N; i++) {
            can[cnt++] = a[i];
        }
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                if (a[i] != a[j]) {
                    can[cnt++] = llabs(a[i] - a[j]);
                }
            }

        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = 0; k < N; k++)
                    if (k != i && k != j && a[i] + a[j] != a[k]) {
                        can[cnt++] = llabs(a[i] + a[j] - a[k]);
                        if ((a[i] + a[j] - a[k]) % 2 == 0) {
                            can[cnt++] = llabs(a[i] + a[j] - a[k]) / 2;
                        }
                    }

        sort(can, can + cnt);
        cnt = unique(can, can + cnt) - can;
        int ans = 0;
        for (int x = 0; x < cnt; x++)
            for (int y = x; y < cnt; y++)
                for (int z = y; z < cnt; z++) {
                    int A = can[x], B = can[y], C = can[z];
                    bool check = true;
                    for (int i = 0; i < N; i++)
                        if (a[i] != A && a[i] != B && a[i] != C &&
                            a[i] != A + B && a[i] != A + C && a[i] != B + C &&
                            a[i] != A + B + C) {
                            check = false;
                            break;
                        }

                    if (check) {
                        ans++;
                    }
                }

        printf("%d\n", ans);
    }
    return 0;
}
