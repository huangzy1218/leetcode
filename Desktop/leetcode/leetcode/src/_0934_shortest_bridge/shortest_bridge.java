/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 * An island is a 4-directionally connected group of 1's not connected to any other 1's.
 * There are exactly two islands in grid.
 * You may change 0's to 1's to connect the two islands to form one island.
 * Return the smallest number of 0's you must flip to connect the two islands.
 * Example:
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 */

package _0934_shortest_bridge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    /* 广度 + 深度优先搜索 */
    Queue<int[]> que;
    int n;
    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] grid) {
        que = new ArrayDeque<>();
        n = grid.length;
        int step = 0;
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break outer;
                }
            }
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int j = 0; j < size; j++) {
                int[] point = que.poll();
                for (int[] dir : DIRS) {
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (grid[nx][ny] == 1) {
                            return step;
                        } else if (grid[nx][ny] == 0) {
                            que.offer(new int[]{nx, ny});
                            grid[nx][ny] = -1;
                        }
                    }
                }
            }
            ++step; // 注意位置，第一层为第一座岛的边缘
        }
        return 0;
    }

    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) { // 注意为 != 1
            return;
        }
        que.offer(new int[]{x, y});
        grid[x][y] = -1;
        for (int[] dir : DIRS) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }
        /* 广度优先搜素 */
/*
        int n = grid.length;
        final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> islands = new ArrayList<>(); // 记录第 1 个岛屿的位置
        Queue<int[]> que = new ArrayDeque<>();
        int step = 0;
        outer: // 跳出双层循环
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    que.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    break outer;
                }
            }
        }
        while (!que.isEmpty()) {
            int[] point = que.poll();
            islands.add(point);
            for (int[] dir : DIRS) {
                int nx = point[0] + dir[0];
                int ny = point[1] + dir[1];
                while (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                    que.offer(new int[]{nx, ny});
                    grid[nx][ny] = -1;
                }
            }
        }
        for (int[] island : islands) {
            que.offer(island);
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int j = 0; j < size; j++) {
                int[] point = que.poll();
                for (int[] dir : DIRS) {
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (grid[nx][ny] == 1) {
                            return step;
                        } else if (grid[nx][ny] == 0) {
                            que.offer(new int[]{nx, ny});
                            grid[nx][ny] = -1;
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
*/
}

