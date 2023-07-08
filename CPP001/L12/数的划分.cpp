#include <bits/stdc++.h>
using namespace std;

int n, k, a[7], cnt;

void dfs(int pos) {
	if (n == 0) return;
	if (pos == k) {
		if (n >= a[pos - 1]) {
			cnt++;
		}
		return;
	}
	//上下界剪枝
	//第x个数可以选择的范围
	for (int i = a[pos - 1]; i <= n / (k - pos + 1); i++) {
		a[pos] = i;
		n -= i;
		dfs(pos + 1);
		n += i;
	}
}

int main() { 
	cin >> n >> k;
	a[0] = 1; //a[i]最小从1开始
	dfs(1);
	cout << cnt << endl;
	return 0;
}