/*
ID: mailtoc1
TASK: gift1
LANG: C++11
*/
#include <bits/stdc++.h>
using namespace std;

string name[11];
map<string, int> mymap;  // key  value

int main() {
    // freopen("gift1.in", "r", stdin);
    // freopen("gift1.out", "w", stdout);
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> name[i];
    }

    string giver;
    int gift, num;
    for (int i = 0; i < n; i++) {
        cin >> giver >> gift >> num;
        if (num > 0) {
            int average = gift / num;
            string receiver;
            for (int i = 0; i < num; i++) {
                cin >> receiver;
                mymap[receiver] += average;
            }

            mymap[giver] -= average * num;
        }
    }

    for (int i = 0; i < n; i++) {
        cout << name[i] << ' ' << mymap[name[i]] << endl;
    }

    return 0;
}
