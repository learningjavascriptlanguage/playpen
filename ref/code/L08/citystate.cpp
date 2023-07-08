#include<bits/stdc++.h>
#define LL long long
using namespace std;

map<string, LL> m;
LL cnt; // 总对数

int main() {
	// freopen("citystate.in", "r", stdin);
    // freopen("citystate.out", "w", stdout);
	ios::sync_with_stdio(false);
	cin.tie(0);

	int n;
	cin>>n;
	for(int i=0; i<n; i++) {
		string a, b;
		cin>>a>>b;
		a = a.substr(0, 2);
		if(a != b) { // 来自不同的省 
			string key = a + b;
			m[key]++;
		}
	}
	for(auto &e : m) {
		string key1 = e.first;
		string key2 = key1.substr(2) + key1.substr(0, 2);
		cnt += m[key1] * m[key2];
	}

	cout << cnt/2 << endl;
    return 0;
} 

