#include<bits/stdc++.h>
using namespace std;
int n;

struct patient {
	int id;
	int p;
};

bool cmp(patient a, patient b) {
	return a.p > b.p;
}

priority_queue<patient, vector<patient>, cmp> pq(10);
int main() {
	while (cin >> n and n != EOF) {
		while (n--) {
			string s;
			int a, b;
			cin >> s >> a >> b;
			if (s == "IN") {
				pq[a].push(b);
			}
			else if (s == "OUT" and !pq[a].empty()) {
				cout << pq[a].top() << endl;
				pq[a].pop();
			}
			else {
				cout << "EMPTY" << endl;
			}
		}
	}
	
}