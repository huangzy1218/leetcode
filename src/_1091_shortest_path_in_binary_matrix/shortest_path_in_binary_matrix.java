/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * 1. All the visited cells of the path are 0.
 * 2. All the adjacent cells of the path are 8-directionally connected
 *  (i.e., they are different and they share an edge or a corner).
 * 3. The length of a clear path is the number of visited cells of this path.
 */

package _1091_shortest_path_in_binary_matrix;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /* 广度优先搜索 */
    public int shortestPathBinaryMatrix(int[][] grid) {
        final int[] DIR_X = {1, 1, 1, 0, 0, -1, -1, -1};
        final int[] DIR_Y = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = grid.length;
        if (grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0, 0});
        grid[0][0] = 1;
        int path = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) { // 非常必要，记录当前层次
                int[] point = que.poll();
                int x = point[0], y = point[1];
                if (x == n - 1 && y == n - 1) {
                    return path;
                }
                for (int i = 0; i < 8; i++) {
                    int newX = x + DIR_X[i];
                    int newY = y + DIR_Y[i];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        que.offer(new int[] {newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
                size--;
            }
            path++;
        }
        return -1;
    }
}
