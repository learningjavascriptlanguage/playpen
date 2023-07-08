#include <bits/stdc++.h>
using namespace std;

int a[1000];
int t[1000];

void mSort(int left, int right) {
    if (left == right) return;

    int mid = (left + right) / 2;
    mSort(left, mid);
    mSort(mid + 1, right);

    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
        if (a[i] <= a[j]) {
            t[k] = a[i];
            i++;
        } else {
            t[k] = a[j];
            j++;
        }
        k++;
    }

    while (i <= mid) {
        t[k] = a[i];
        i++, k++;
    }

    while (j <= right) {
        t[k] = a[j];
        j++, k++;
    }

    for (int i = left; i <= right; i++) {
        a[i] = t[i];
    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }

    mSort(1, n);

    for (int i = 1; i <= n; i++) {
        cout << a[i] << " ";
    }

    return 0;
}
