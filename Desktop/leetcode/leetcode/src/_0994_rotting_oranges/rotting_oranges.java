/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible,
 * return -1.
 * Example:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */

package _0994_rotting_oranges;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int m, n;
    int[][] grid;
    /* 广度优先搜索 */
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int rottenCounts = 0;
        int freshCounts = 0;
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++freshCounts;
                }
            }
        }
        while (!que.isEmpty() && freshCounts > 0) {
            int sz = que.size();
            ++rottenCounts;
            for (int i = 0; i < sz; i++) {
                int[] point = que.poll();
                for (int[] dir : DIRS) {
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        --freshCounts;
                        grid[nx][ny] = 2;
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return freshCounts == 0 ? rottenCounts : -1;
    }
    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /* 深度优先搜索 （不推荐） */
/*
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int rottenCounts = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) { // 感染
                    dfs(i, j, 2); // level = 2，表示层次为 0，为避免与 0、1 冲突
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // 有橘子未被感染
                    return -1;
                } else {
                    rottenCounts = Math.max(grid[i][j], rottenCounts);
                }
            }
        }
        return rottenCounts == 0 ? 0 : rottenCounts - 2;
    }
    private void dfs(int x, int y, int level) { // currenrLevel
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (grid[x][y] != 1 && level > grid[x][y]) { // 必须为新鲜橙子并且层次小于原层次
            return;
        }
        // 当前层次操作
        grid[x][y] = level;
        level++; // 层级 + 1
        dfs(x - 1, y, level);
        dfs(x + 1, y, level);
        dfs(x, y - 1, level);
        dfs(x, y + 1, level);
    }
 */
}
