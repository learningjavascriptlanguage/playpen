#include <bits/stdc++.h>    
using namespace std;
queue<int> q;

int main() {
    int tot, outNum;
    cin >> tot >> outNum;
    for (int i = 1; i <= tot; i++)
        q.push(i);    //初始化队列

    while (!q.empty()) {
        for (int i = 1; i <= outNum - 1; i++) {
            q.push(q.front());            //排至队尾
            q.pop();
        }
        cout << q.front() << " ";
        q.pop();
    }
    cout << endl;

    return 0;
}