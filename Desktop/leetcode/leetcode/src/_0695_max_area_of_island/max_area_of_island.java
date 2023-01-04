/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges
 * of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 on the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * Example:
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *                [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *                [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *                [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *                [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *                [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *                [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *                [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
package _0695_max_area_of_island;

class Solution {
    /* 深度优先搜素 */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, infectAndCalArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    int infectAndCalArea(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] != 1) {
            return 0;
        }
        int area = 1;
        grid[x][y] = 2;
        area += infectAndCalArea(grid, x - 1, y);
        area += infectAndCalArea(grid, x + 1, y);
        area += infectAndCalArea(grid, x, y - 1);
        area += infectAndCalArea(grid, x, y + 1);
        return area;
    }
}
