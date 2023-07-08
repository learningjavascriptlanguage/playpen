#include <bits/stdc++.h>
using namespace std;

int c[101];
int main() {
	int n, m,t;
	cin >> n >> m;
	for (int i = 1; i <= m; i++) {
		cin >> c[i];
	}

	for (int i = m + 1; i <= n; i++){
		cin >> t;
		int minindex = 1;
		for (int j = 2; j <= m; j++) {
			if (c[minindex] > c[j]) {
				minindex = j;
			}
		}
		c[minindex] += t;
	}

	int ans = 0;
	for (int i = 1; i <= m; i++) {
		ans = max(ans, c[i]);
	}
	cout << ans << endl;
	 
}