#include <bits/stdc++.h>
#define ll long long
using namespace std;

struct Shop {
    int quantity;
    int price;
};

ll maxProfit[100001];
int milk[100001];
Shop shops[100001];
int rental[100001];

bool cmpShop(const Shop &a, const Shop &b) {
    return a.price > b.price;
}

int main() {
    freopen("rental.in","r",stdin);
    freopen("rental.out","w",stdout);
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    int n, m, r;
    cin >> n >> m >> r;
    for (int i = 0; i < n; i++) {
        cin >> milk[i];
    }
    sort(milk, milk + n, greater<int>());

    for (int i = 0; i < m; i++) {
        int q, p;
        cin >> q >> p;
        shops[i] = {q, p};
    }
    sort(shops, shops + m, cmpShop);

    for (int i = 0; i < r; i++) {
        cin >> rental[i];
    }
    sort(rental, rental + n, greater<int>());

    int index = 0;  // 商店下标
    for (int i = 0; i < n; i++) {
        maxProfit[i + 1] = maxProfit[i];
        while (index < m && milk[i] > 0) {
            ll change = min(milk[i], shops[index].quantity);
            maxProfit[i + 1] += change * shops[index].price;
            milk[i] -= change;
            shops[index].quantity -= change;
            if (shops[index].quantity == 0) {
                index++;
            }
        }
    }

    int i = n - 1;
    int rentalIndex = 0;
    ll rentalProfit = 0; // suffix sum
    while (i >= 0 && rentalIndex < r) {  // 出租牛
        rentalProfit += rental[rentalIndex]; // suffix sum
        maxProfit[i] += rentalProfit;
        rentalIndex++;
        i--;
    }

    ll ans = 0;
    for (int i = 0; i <= n; i++) {  // 注意等于号
        ans = max(ans, maxProfit[i]);
    }
    cout << ans << endl;

    return 0;
}
