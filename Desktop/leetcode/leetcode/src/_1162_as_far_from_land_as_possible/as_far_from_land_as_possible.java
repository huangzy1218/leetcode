/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 * find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
 * If no land or water exists in the grid, return -1.
 * The distance used in this problem is the Manhattan distance: the distance between
 * two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * Example:
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 */

package _1162_as_far_from_land_as_possible;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /* 多源最短路 */
    public int maxDistance(int[][] grid) {
        final int[] DIR_X = {0, -1, 1, 0};
        final int[] DIR_Y = {-1, 0, 0, 1};
        Queue<int[]> que = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    que.offer(new int[]{i, j});
                }
            }
        }
        boolean hasOcean = false;
        int[] point = null;
        // 从各个陆地开始，一圈一圈遍历海洋，最后遍历到的海洋就是离陆地最远的海洋
        while (!que.isEmpty()) {
            point = que.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + DIR_X[i];
                int newY = y + DIR_Y[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    hasOcean = true;
                    grid[newX][newY] = grid[x][y] + 1;
                    que.offer(new int[] {newX, newY});
                }
            }
        }
        if (hasOcean == false)
            return -1;
        // 返回最后一次遍历到的海洋的距离
        return grid[point[0]][point[1]] - 1;
    }
}
