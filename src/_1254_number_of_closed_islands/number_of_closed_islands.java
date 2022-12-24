/**
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island
 * is an island totally all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * Example:
 * Input: grid = [[1,1,1,1,1,1,1,0],
 *                [1,0,0,0,0,1,1,0],
 *                [1,0,1,0,1,1,1,0],
 *                [1,0,0,0,0,1,0,1],
 *                [1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 */
package _1254_number_of_closed_islands;

class Solution {
    /* 深度优先搜索 */
    public int closedIsland(int[][] grid) {
        int islandCounts = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (isClosed(grid, i, j))
                        islandCounts++;
                }
            }
        }
        return islandCounts;
    }
    private boolean isClosed(int[][]grid, int x, int y) {
        // 不包含边界
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 0) {
            grid[x][y] = 2; // 已访问
            boolean up = isClosed(grid, x - 1, y);
            boolean down = isClosed(grid, x + 1, y);
            boolean left = isClosed(grid, x, y - 1);
            boolean right = isClosed(grid, x, y + 1);
            return up && down && left && right;
        }
        return true;

    }
}
