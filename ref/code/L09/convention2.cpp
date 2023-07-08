#include <bits/stdc++.h>
using namespace std;

struct cow {
    int arrive, t, seniority;
};

cow cows[100001];

bool cmp(const cow &c1, const cow &c2) {
    if (c1.arrive != c2.arrive) {
        return c1.arrive < c2.arrive;
    }
    return c1.seniority < c2.seniority;  // ��Ҫ©��
}

struct cmpPrior {
    bool operator()(const cow &a, const cow &b) {
        return a.seniority > b.seniority;
    }
};

priority_queue<cow, vector<cow>, cmpPrior> pq; // ��ǰ���ڵȴ��Բݵ�ţ

int main() {
    freopen("convention2.in", "r", stdin);
    freopen("convention2.out", "w", stdout);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a, t;
        scanf("%d%d", &a, &t);
        cows[i] = {a, t, i};
    }
    sort(cows, cows + n, cmp);

    pq.push(cows[0]);
    int last = cows[0].arrive;  // ��һͷţ�Բݽ���ʱ��
    int answer = 0;
    int cnt = 1;  // �Ѽ�������е�ţͷ��

    while (!pq.empty()) {
        cow c = pq.top();
        pq.pop();
        int wait = max(0, last - c.arrive);
        answer = max(answer, wait);
        last = c.arrive + wait + c.t;
        // ���Ѿ������ţ�������
        for (int i = cnt; i < n; i++) {
            if (cows[i].arrive <= last) {
                pq.push(cows[i]);
                cnt++;
            } else {
                break;
            }
        }
        // ��������Ϊ�գ���ʾ��ǰ��һͷţ�Բݽ���ʱ��������ţ��δ����
        if (pq.empty() && cnt < n) {
            pq.push(cows[cnt]);
            cnt++;
        }
    }
    cout << answer << endl;

    return 0;
}
