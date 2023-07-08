#include <bits/stdc++.h>
using namespace std;
struct cow{
    int x, y, id;
    int dis;
    int cnt;
};

const int MAXN = 1001;
int N, cnte, cntn;
cow e[MAXN], n[MAXN];

bool cmpe(const cow &a, const cow &b){
    return a.y<b.y;
}

bool cmpn(const cow &a, const cow &b){
    return a.x<b.x;
}

bool cmpid(const cow &a, const cow &b) {
    return a.id < b.id;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin>>N;
    char c;
    int x, y;
    for(int i=1;i<=N;i++){
        cin>>c>>x>>y;
        if(c=='E'){
            cnte++;
            e[cnte]={x, y, i, INT_MAX, 0};
        }else{
            cntn++;
            n[cntn]={x, y, i, INT_MAX, 0};
        }
    }
    sort(e+1, e+cnte+1, cmpe);
    sort(n+1, n+cntn+1, cmpn);
    for(int i=1;i<=cntn;i++){
        for(int j=1;j<=cnte;j++){
            if(e[j].dis != INT_MAX) { // 已访问
                continue;
            }

            int lenx=n[i].x-e[j].x;
            int leny=e[j].y-n[i].y;
            if(lenx==leny || lenx < 0 || leny < 0) {// 不相交
                continue;
            }

            if(lenx>leny){
                n[i].cnt += e[j].cnt + 1;
                e[j].dis = lenx;
            }else{
                e[j].cnt += n[i].cnt + 1;
                n[j].dis = leny;
                break;
            }
        }
    }
    for(int i=1; i<=cntn; i++) {
        e[cnte + i] = n[i];
    }
    sort(e+1, e+1+N, cmpid);

    for(int i=1; i<=N; i++) {
        cout<<e[i].cnt<<'\n';
    }

    return 0;
}