#include<bits/stdc++.h>
using namespace std;

struct road {
    int id, cnt;     //id:隔开的道路编号 cnt:隔开的组数
};

road row[1005], col[1005]; // K横向通道，L纵向通道

bool cmpCnt(const road& x, const road& y) {
    return x.cnt > y.cnt;
}

bool cmpId(const road& x, const road& y) {
    return x.id < y.id;
}

int main() {
    int m, n, k, L, d;
    cin >> m >> n >> k >> L >> d;

    for (int i = 1; i <= m; i++) {
        row[i].id = i;
        row[i].cnt = 0;
    }

    for (int i = 1; i <= n; i++) {
        col[i].id = i;
        col[i].cnt = 0;
    }

    for (int i = 1; i <= d; i++) {
        int xi, yi, pi, qi;
        cin >> xi >> yi >> pi >> qi;
        if (xi == pi) {  // 在同一行
            int id = min(yi, qi);
            col[id].cnt++;
        }
        else {      // 在同一列
            int id = min(xi, pi);
            row[id].cnt++;
        }
    }

    // 隔开人数从大到小排序（贪心）
    sort(row + 1, row + m + 1, cmpCnt);
    sort(col + 1, col + n + 1, cmpCnt);

    // 在上述排序基础上，道路编号从小到大排(前K行，前L列)
    sort(row + 1, row + k + 1, cmpId);
    sort(col + 1, col + L + 1, cmpId);

    for (int i = 1; i <= k; i++)
        cout << row[i].id << " ";

    cout << endl;

    for (int i = 1; i <= L; i++)
        cout << col[i].id << " ";
    return 0;
}