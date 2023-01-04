/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or
 * walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot
 * walk off the boundary of the grid in any number of moves.
 * Example:
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 */

package _1020_number_of_enclaves;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /* 深度优先搜索 */
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        int enclavesCounts = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclavesCounts++;
                }
            }
        }
        return enclavesCounts;
    }

    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }

    /* 广度优先搜索 */
/*
    final int[] DIR_X = {1, 0, -1, 0};
    final int[] DIR_Y = {0, -1, 0, 1};
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && grid[i][j] == 1) {
                    que.offer(new int[]{i, j});
                    grid[i][j] = 0; // 表示已访问
                }
            }
        }
        while (!que.isEmpty()) {
            int[] dir = que.poll();
            int x = dir[0], y = dir[1];
            for (int i = 0; i < 4; i++) {
                int dx = x + DIR_X[i];
                int dy = y + DIR_Y[i];
                if (dx >= 0 && dx < m && dy >=0 && dy < n && grid[dx][dy] == 1) {
                    grid[dx][dy] = 0;
                    que.offer(new int[]{dx, dy});
                }
            }
        }
        int enclavesCounts = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclavesCounts++;
                }
            }
        }
        return enclavesCounts;
    }
 */
}
