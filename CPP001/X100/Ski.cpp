#include <bits/stdc++.h>
using namespace std;

int dp[101][101] = {};
int m, n, ans = 1;

int dfs(vector<vector<int>>& matrix, int i, int j, int prev) {
    if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prev) return 0;
    if (dp[i][j]) return dp[i][j];
    return dp[i][j] = 1 + max({
        dfs(matrix,i + 1,j,matrix[i][j]),
        dfs(matrix,i,j + 1,matrix[i][j]),
        dfs(matrix,i - 1,j,matrix[i][j]),
        dfs(matrix,i,j - 1,matrix[i][j])
        });
}

int longestDecreasingPath(vector<vector<int>>& matrix) {
    m = matrix.size(), n = matrix[0].size();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            ans = max(ans, dfs(matrix, i, j, -1));
        }
    }
    return ans;
}

int main() {
    cin >> m >> n;
    vector<vector<int>> matrix(m + 5, vector<int>(n + 5));
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }
    cout << longestDecreasingPath(matrix) << endl;
}