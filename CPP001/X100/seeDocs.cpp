#include <bits/stdc++.h>
using namespace std;

struct patient {
	int id;
	int p;
};

struct cmp {
	bool operator()(patient& a, patient& b) {
		if (a.p == b.p) {
			return a.id > b.id;
		}
		else {
			return a.p < b.p;
		}
	}
};

priority_queue<patient, vector<patient>, cmp> pq1;
priority_queue<patient, vector<patient>, cmp> pq2;
priority_queue<patient, vector<patient>, cmp> pq3;

int main() {
	int n;
	while (cin >> n) {
		int i = 1;
		while (n--) {
			string s;
			int a, b;
			cin >> s;
			patient cur;
			if (s == "IN") {
				cin >> a >> b;
				cur = { i, b };
			}
			else if (s == "OUT") {
				cin >> a;
			}

			if (s == "IN" and a == 1) {
				pq1.push(cur);
				i++;
			}
			else if (s == "IN" and a == 2) {
				pq2.push(cur);
				i++;
			}
			else if (s == "IN" and a == 3) {
				pq3.push(cur);
				i++;
			}
			else if (s == "OUT" and a == 1 and !pq1.empty()) {
				cout << pq1.top().id << endl;
				pq1.pop();
			}
			else if (s == "OUT" and a == 2 and !pq2.empty()) {
				cout << pq2.top().id << endl;
				pq2.pop();
			}
			else if (s == "OUT" and a == 3 and !pq3.empty()) {
				cout << pq3.top().id << endl;
				pq3.pop();
			}
			else {
				cout << "EMPTY" << endl;
			}
		}
	}
	system("pause");
	return 0;
}