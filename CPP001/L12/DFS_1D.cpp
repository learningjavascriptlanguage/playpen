#include <bits/stdc++.h>
using namespace std;

int a[10], ans[10];
bool vis[1001];
int n;

void dfs(int pos) {
	if (pos == n + 1) {
		for (int i = 1; i <= n; i++) {
			cout << ans[i] << " ";
		}
		cout << endl;
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (!vis[a[i]]) {
			ans[pos] = a[i];
			vis[a[i]] = true;
			dfs(pos + 1);
			vis[a[i]] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}

	dfs(1);
	
	return 0;
}