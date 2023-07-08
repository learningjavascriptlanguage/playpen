#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m, t;
	cin >> n >> m;
	int cnt = 1;
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		cin >> t;
		if (sum + t <= m) {
			sum += t;
		}
		else {
			cnt++;
			sum = t;
		}
	}
	cout << cnt << endl;
}