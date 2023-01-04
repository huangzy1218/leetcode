/**
 * An image is represented by an m x n integer grid image where
 * image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected
 * 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 * Example:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 * Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */

package _0733_flood_fill;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /* 深度优先搜索 */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] != oldColor || image[x][y] == newColor) {
            return;
        }
        image[x][y] = newColor;
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
    }
    /* 广度优先搜索 */
/*
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int x = pos[0], y = pos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == oldColor) {
                    image[nx][ny] = color;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        return image;
    }
*/
}
