#include<bits/stdc++.h>
using namespace std;

int main() {
	freopen("moobuzz.in", "r", stdin);
	freopen("moobuzz.out", "w", stdout);
	int n;
	cin>>n;
    int num[]={1, 2, 4, 7, 8, 11, 13, 14};
    cout<< (n-1) / 8 * 15 + num[(n-1) % 8] << endl;
	return 0;
}
