#include <bits/stdc++.h>
using namespace std;

int cnt;

void hanoi(int n, char a, char b, char c) {
    if (n == 1) {
        cout << a << "->" << c << endl;
        cnt++;
        return;
    }

    hanoi(n - 1, a, c, b);
    cout << a << "->" << c << endl;
    hanoi(n - 1, b, a, c);
}

int main() {
    int n;
    cin >> n;
    hanoi(n, 'A', 'B', 'C');
    cout << "һ���ƶ���" << cnt << "��" << endl;
    return 0;
}