/**
 * Given an m x n binary matrix mat, return the distance of the
 * nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * Example:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */

package _0542_01_matrix;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /* 广度优先搜索 */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[] {i, j}); // 直接添加，距离 0 的距离为 0
                } else {
                    mat[i][j] = m + n; // 设置为最大距离（极端情况）
                }
            }
        }
        while (!que.isEmpty()) {
            int[] point = que.poll();
            int x = point[0], y = point[1];
            for (int[] dir : DIRS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n
                        && mat[x][y] + 1 < mat[newX][newY]) {
                    mat[newX][newY] = mat[x][y] + 1; // 最小距离 + 1
                    que.offer(new int[] {newX, newY});
                }
            }
        }
        return mat;
    }
}
