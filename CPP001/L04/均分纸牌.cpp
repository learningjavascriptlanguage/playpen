#include <bits/stdc++.h>
using namespace std;

int a[101];

int main()
{
    int n, p = 0;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        p += a[i];
    }
    p /= n;
    for (int i = 0; i < n; i++)
        a[i] -= p;

    int total = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] == 0)
            continue;
        a[i + 1] += a[i];
        total++;
    }
    cout << total << endl;
    return 0;
}
