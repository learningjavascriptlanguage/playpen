#include <bits/stdc++.h>
using namespace std;

const int MOD = 10000;

stack<int> st;

// st.push(n)  往栈顶添加一个元素
// st.pop()    从栈顶删除一个元素
// st.top()    返回栈顶的元素，不改变队列内容 
// st.size()   返回栈中元素的个数
// st.empty()  判断栈是否为空，如果为空，则返回true 

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int a;
	cin >> a;
	st.push(a % MOD);
	char c;
	while (cin >> c >> a) {
		if (c == '+') {
			st.push(a % MOD);
		}

		if (c == '*') {
			int b = st.top();
			st.pop();
			st.push((b * (a % MOD)) % MOD);
		}
	}

	int sum = 0;
	while (!st.empty()) {
		sum = (sum + st.top()) % MOD;
		st.pop();
	}

	cout << sum % MOD << endl;

	return 0;
}
