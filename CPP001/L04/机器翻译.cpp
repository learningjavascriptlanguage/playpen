#include<bits/stdc++.h>
using namespace std;

queue<int> q;
bool book[1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int m, n, word, cnt = 0;
    cin >> m >> n;

    for (int i = 0; i < n; i++) {
        cin >> word;
        if (book[word]) {
            continue;
        }
        if (q.size() == m) {
            book[q.front()] = false;
            q.pop();
        }
        q.push(word);
        book[word] = true;
        cnt++;
    }

    cout << cnt << endl;
    return 0;
}