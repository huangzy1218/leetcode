/**
 * You are given two m x n binary matrices grid1 and grid2 containing
 * only 0's (representing water) and 1's (representing land). An island is a
 * group of 1's connected 4-directionally (horizontal or vertical).
 * Any cells outside of the grid are considered water cells.
 * An island in grid2 is considered a sub-island if there is an island in grid1
 * that contains all the cells that make up this island in grid2.
 * Return the number of islands in grid2 that are considered sub-islands.
 * Example:
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 */

package _1905_count_sub_islands;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    boolean notSub;
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int gridCounts = 0;
        m = grid1.length;
        n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    notSub = false;
                    dfs(grid1, grid2, i, j);
                    if (!notSub) gridCounts++;
                }
            }
        }
        return gridCounts;
    }

    void dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid2[x][y] == 0) {
            return; // 返回上一层
        }
        if (grid1[x][y] == 0) { // 不是水域
            notSub = true;
        }
        grid2[x][y] = 0; // 已访问
        dfs(grid1, grid2, x - 1, y);
        dfs(grid1, grid2, x + 1, y);
        dfs(grid1, grid2, x, y - 1);
        dfs(grid1, grid2, x, y + 1);
    }

    /* 广度优先搜索 */
/*
    boolean notSub;
    int m, n;
    Queue<int[]> que;
    final int[] DIR_X = {0, -1, 1, 0};
    final int[] DIR_Y = {-1, 0, 0, 1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int gridCounts = 0;
        m = grid1.length;
        n = grid1[0].length;
        que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    notSub = false;
                    bfs(grid1, grid2, i, j);
                    if (!notSub) gridCounts++;
                }
            }
        }
        return gridCounts;
    }

    void bfs(int[][] grid1, int[][] grid2, int x, int y) {
        que.offer(new int[]{x, y});
        grid2[x][y] = 0; // 已访问
        if (grid1[x][y] == 0)
            notSub = true;
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int curX = pos[0];
            int curY = pos[1];
            for (int i = 0; i < 4; i++) {
                int mx = curX + DIR_X[i];
                int my = curY + DIR_Y[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && grid2[mx][my] == 1) {
                    que.offer(new int[]{mx, my});
                    grid2[mx][my] = 0;
                    if (grid1[mx][my] == 0) {
                        notSub = true;
                    }
                }
            }
        }
    }
 */
}
