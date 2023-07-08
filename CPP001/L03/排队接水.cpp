#include <bits/stdc++.h>
using namespace std;

struct people {
	int t, id;
};

bool cmp(const people& a, const people& b) {
	return a.t < b.t;
}

int n;
people a[1001];
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i].t;
		a[i].id = i + 1;
	}
	sort(a, a + n, cmp);
	double sum = 0;
	for (int i = 0; i < n - 1; i++) {
		sum += a[i].t * (n - 1 - i);
	}

	for (int i = 0; i < n-1; i++) {
		cout << a[i].id << " ";
	}
	cout << a[n-1].id << endl;
	cout << fixed << setprecision(2) << sum / n << endl;
}