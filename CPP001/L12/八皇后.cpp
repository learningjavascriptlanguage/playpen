#include <bits/stdc++.h>
using namespace std;

//a表示行
//b表示列
//c表示/对角线
//d表示\对角线
int a[100]; //记录当前方案
bool b[100], c[100], d[100];

int total; //总数
int n;     //N*N的格子

void dfs(int row) {//第row行
	if (row == n + 1) {
		total++;
		//如果解超出三组就不再输出
		if (total <= 30) {
			for (int k = 1; k <= n; k++)
				cout << a[k] << " ";
			cout << endl;
		}
		return;
	}

	//尝试可能的位置
	for (int col = 1; col <= n; col++) {
		//该列如果没有皇后占领
		// /对角线行列值之和相同，
		// \对角线行列值之差相同（因为数组下标不能为负，故加n）
		if (!b[col] && !c[row + col] && !d[row - col + n]) {
			a[row] = col; //标记i排放在第j列
			b[col] = true;//宣布占领纵列
			c[row + col] = true;     //宣布占领/对角线
			d[row - col + n] = true; //宣布占领\对角线
			// 进一步搜索下一行的皇后
			dfs(row + 1);
			// 回到上一步，清楚标记
			b[col] = false;
			c[row + col] = false;
			d[row - col + n] = false;
		}
	}
}

int main() {
	cin >> n;
	dfs(1);
	cout << total;
	return 0;
}