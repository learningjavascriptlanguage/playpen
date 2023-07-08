#include <bits/stdc++.h>
using namespace std;

int a[15];

int main()
{
    int n;
    cin>>n;

    for(int i=0; i<n; i++) {
        a[i] = i + 1;
    }

    do {
        for (int i = 0; i < n; i++) {
            cout<<a[i]<<" ";
        }
        cout<<endl;
    } while (next_permutation(a, a + n)); // previous_permutation

    return 0;
}
