#include<bits/stdc++.h>
using namespace std;

int a[100001];
int n, q;

int countHaybales(int limit) {
	if (a[0] > limit) {
		return 0;
	}

	int left = 0;
	int right = n - 1;
	int ans = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
		if (a[mid] <= limit) {
			ans = mid;
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}

	return ans+1; // 下标从0开始，需加1
}

int main() {
	freopen("haybales.in", "r", stdin);
    freopen("haybales.out", "w", stdout);
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin>>n>>q;
	for(int i=0; i<n; i++) {
		cin>>a[i];
	}

	sort(a, a+n);

	for(int i=0; i<q; i++) {
		int a, b;
		cin>>a>>b;
		cout<<countHaybales(b)-countHaybales(a-1)<<endl;
	}

    return 0;
} 

