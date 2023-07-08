#include <bits/stdc++.h>
using namespace std;

struct record {
    int day;
    int cow;
    int delta;
};

record A[100001];

bool cmp(const record &a, const record &b) { 
    return a.day < b.day;
}

int main() {
    // freopen("measurement.in", "r", stdin);
    // freopen("measurement.out", "w", stdout);
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, G;
    cin >> N >> G;

    for (int i = 0; i < N; i++) {
        cin >> A[i].day >> A[i].cow >> A[i].delta;
    }
    sort(A, A + N, cmp);

    // key��ţ�ı��  value: ��Ӧ��ţ���̱仯��
    map<int, int> everyCow;
    // key���ܵĲ��̱仯��  value ��Ӧ��ţ��ͷ��
    map<int, int, greater<int> > totalChange;  // ���ܵĲ��̱仯����������
    // ��ע�⣬ũ��Լ����һ��Ⱥ��ţ��
    // ���Ծ�����־�м�¼��һЩ��ţ�ı��˲�������
    // ����Ȼ���кܶ���ţ�Ĳ�����������G���ء�
    totalChange[0] = N + 1;

    int ans = 0;
    for (int i = 0; i < N; i++) {
        // ����ڱ仯֮ǰ����ǰ��ͷţ�Ƿ��ǹھ����Լ�����ͷţ������һ����ţ������
        int milk = everyCow[A[i].cow];

        bool wasTop = (milk == totalChange.begin()->first);  //�仯ǰ�Ƿ�Ϊ�ھ�
        int wasCnt = totalChange[milk];

        // ����milk��Ӧ����ţͷ��
        if (wasCnt == 1) {
            totalChange.erase(milk);
        } else if (wasCnt > 1) {
            totalChange[milk]--;
        }

        // ���²�����
        milk += A[i].delta;
        everyCow[A[i].cow] = milk;
        totalChange[milk]++;

        bool isTop = (milk == totalChange.begin()->first);  //�仯���Ƿ�Ϊ�ھ�
        int isCnt = totalChange[milk];

        if (wasTop != isTop) {
            ans++;
        } else if (wasTop && isTop && wasCnt != isCnt) {
            // �仯ǰ�������ߵ�ţ������һ��
            ans++;
        }
    }
    cout << ans << endl;

    return 0;
}
