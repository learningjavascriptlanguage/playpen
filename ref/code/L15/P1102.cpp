#include <bits/stdc++.h>
using namespace std;
int a[200001];
long long N, C, ans;
int main()
{
    cin >> N >> C;
    for (int i = 1; i <= N; i++)
    {
        cin >> a[i];
    }
    sort(a + 1, a + N + 1);
    for (int i = 1; i <= N; i++)
    {
        ans += upper_bound(a + 1, a + N + 1, a[i] + C) 
                - lower_bound(a + 1, a + N + 1, a[i] + C);

        // pair<int* , int*> bounds = equal_range(a + 1, a + N + 1, a[i] + C);
        // ans += bounds.second - bounds.first;
    }
    cout << ans;
    return 0;
}