#include <iostream>
#include <vector>

using namespace std;

// Function to count the number of paths and find the shortest path
void countPathsAndFindShortestPath(vector<vector<int>>& maze, int row, int col, int& numPaths, vector<vector<int>>& shortestPath, vector<vector<int>>& currentPath) {
    // Check if current cell is out of bounds or a wall
    if (row >= maze.size() || col >= maze[0].size() || maze[row][col] == 1 || row < 1 || col <  1) {
        return;
    }

    // Add current cell to the current path
    currentPath[row][col] = 1;

    // Check if we have reached the bottom right corner
    if (row == maze.size() - 1 && col == maze[0].size() - 1) {
        // Increment the number of paths
        numPaths++;

        // If the current path is shorter than the shortest path found so far
        if (shortestPath.empty() || currentPath.size() < shortestPath.size()) {
            shortestPath = currentPath;
        }
    }

    // Recursive calls for moving right and down
    countPathsAndFindShortestPath(maze, row, col + 1, numPaths, shortestPath, currentPath);
    countPathsAndFindShortestPath(maze, row + 1, col, numPaths, shortestPath, currentPath);
    countPathsAndFindShortestPath(maze, row-1, col, numPaths, shortestPath, currentPath);
    countPathsAndFindShortestPath(maze, row, col-1, numPaths, shortestPath, currentPath);

    // Remove current cell from the current path
    currentPath[row][col] = 0;
}

int main() {
    // Define the maze as a 2D vector
    vector<vector<int> > maze;
    int x, y;
    cin >> x;
    y = x;
    for (int i = 1; i <= x; i++) {
        vector<int> v;
        for (int j = 1; j <= y; j++) {
            int a; cin >> a;
            v.push_back(a);
        }
        maze.push_back(v);
    }
   /* vector<vector<int>> maze = {
        {0, 0, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0},
        {0, 1, 0, 0}
    };*/

    // Initialize variables for counting paths and finding the shortest path
    int numPaths = 0;
    vector<vector<int>> shortestPath;
    vector<vector<int>> currentPath(maze.size(), vector<int>(maze[0].size(), 0));

    // Count the number of paths and find the shortest path
    countPathsAndFindShortestPath(maze, 0, 0, numPaths, shortestPath, currentPath);

    // Print the number of paths
    //cout << "Number of paths: " << numPaths << endl;
    cout << numPaths << endl;

    // Print the shortest path
    //cout << "Shortest path:" << endl;
    int sp = 0;
    for (const auto& rows : shortestPath) {
        for (int cell : rows) {
            //cout << cell << " ";
            if (cell) sp++;
        }
        //cout << endl;
    }
    
    cout << sp << endl;

    return 0;
}
