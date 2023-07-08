#include <bits/stdc++.h>
using namespace std;

int f[1001];

int find(int v) {  // 找root
	if(f[v] == v) {
		return v;
	}

	f[v] = find(f[v]);  // 路径压缩 
	return f[v];
}

void merge(int u, int v) {
	int fu = find(u);
	int fv = find(v);
	if(fu != fv) {
		f[fv] = fu;
	}
	return;
}

/*
输入
10代表强盗个数
9代表线索数

10 9
1 2
3 4
5 2
4 6
2 6
8 7
9 7
1 6
2 4

输出
3
*/
int main() {
	ios::sync_with_stdio(false);
    cin.tie(0);
    
	int n, m;
	cin>>n>>m;

	// 初始化
	for(int i=1; i<=n; i++) {
		f[i] = i;
	}

	for(int i=1; i<=m; i++) {
		int x, y;
		cin>>x>>y;
		merge(x, y);
	}

	int ans = 0;
	for(int i=1; i<=n; i++) {
		if(f[i] == i) ans++;
	}

	cout<<ans<<endl;

    return 0;
}
