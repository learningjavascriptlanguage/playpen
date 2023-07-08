#include<bits/stdc++.h>
using namespace std;
const int MAX_A=100005;
int to[MAX_A];
int inDegree[MAX_A];

int main() {
    int n;
    cin>>n;
    for (int i=1; i<=n; i++) {
        cin>>to[i];
        inDegree[to[i]]++;
    }
    queue<int> q;
    int cnt = 0;
    for (int i=1; i<=n; i++) {
        if (inDegree[i]==0) {
            q.push(i);
            cnt++;
        }
    }
    while (!q.empty()) {
        int t=q.front();
        q.pop();
        int v = to[t]; // t -> v
        inDegree[v]--;
        if (inDegree[v]==0) {
            q.push(v);
            cnt++;
        }
    }
    cout<<n-cnt<<endl;

    return 0;
}
