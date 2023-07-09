#include <bits/stdc++.h>
using namespace std;

long long int MOD = 1e9 + 7;

// Helper function to calculate the number of unique paths
long long int
helper(long long int m, long long int n,
	vector<vector<long long int> >& obstacleGrid)
{
	// Base cases
	if (m < 0 || n < 0) {
		return 0;
	}

	if (obstacleGrid[m][n] == 1) {
		return 0;
	}

	if (m == 0 && n == 0) {
		return 1;
	}

	// Recursively calculate the number of unique paths by
	// considering downward and rightward movements
	return (helper(m - 1, n, obstacleGrid) % MOD
		+ helper(m, n - 1, obstacleGrid) % MOD)
		% MOD;
}

// Function to calculate the number of unique paths with
// obstacles
long long int uniquePathsWithObstacles(
	vector<vector<long long int> >& obstacleGrid)
{
	long long int m = obstacleGrid.size();
	long long int n = obstacleGrid[0].size();

	return helper(m - 1, n - 1, obstacleGrid);
}

int main()
{
	// Example obstacle grid
	vector<vector<long long int> > maze;
	int x, y;
	cin >> x;
	y = x;
	for (int i = 1; i <= x; i++) {
		vector<long long int> v;
		for (int j = 1; j <= y; j++) {
			long long int a; cin >> a;
			v.push_back(a);
		}
		maze.push_back(v);
	}

	// Calculate and print the number of unique paths with
	// obstacles
	cout << uniquePathsWithObstacles(maze);

	return 0;
}
