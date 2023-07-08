#include <bits/stdc++.h>
using namespace std;

int first[7];
int last[7];
    
int main()
{
	freopen("div7.in", "r", stdin);
	freopen("div7.out", "w", stdout);

	ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int n;
    cin>>n;

    memset(first, 0x7f, sizeof(first));
    first[0]=0;
    int prefix = 0;
	for(int i = 1; i <= n; i++) {
		int id;
		cin>>id;
		prefix += id;
		prefix %= 7;
		first[prefix] = min(first[prefix], i);
		last[prefix] = i;
	}
	int ans = 0;
	for(int i = 0; i < 7; i++) {
		ans = max(ans, last[i] - first[i]);
	}
	cout<<ans<<endl;

    return 0;
}
