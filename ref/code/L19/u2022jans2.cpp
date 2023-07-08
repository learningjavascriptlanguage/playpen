#include <bits/stdc++.h>
using namespace std;
int N, a[1000001];
long long ans;

stack<int> st;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    cin>>N;
    for (int i = 1; i <= N; i++) {
		cin>>a[i];
	}
    for (int i = 1; i <= N; i++) {
        while (st.size() > 0 && a[i] > a[st.top()]) {
            ans += i - st.top() + 1;
            st.pop();
        }
        if (st.size() > 0) ans += i - st.top() + 1;
        st.push(i);
	}
	cout<<ans<<endl;
	return 0;
}
