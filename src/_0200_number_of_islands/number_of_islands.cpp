/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

class Solution {
public:
    int numIslands(vector<vector<char>>& grid)
    {
        int islandsCounts = 0;
        int rows = grid.size(), cols = grid[0].size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // 未被感染
                    infect(grid, i, j);
                    islandsCounts++;
                }
            }
        }
        return islandsCounts;
    }

    void infect(vector<vector<char>>& grid, int x, int y)
    {
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size()
            || grid[x][y] != '1') { // 为水域或已被感染
            return;
        }
        grid[x][y] = '2';
        infect(grid, x - 1, y);
        infect(grid, x + 1, y);
        infect(grid, x, y - 1);
        infect(grid, x, y + 1);
    }
};