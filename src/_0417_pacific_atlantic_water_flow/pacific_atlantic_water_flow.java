/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
 * The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights
 * where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north,
 * south, east, and west if the neighboring cell's height is less than or equal to the current cell's height.
 * Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes
 * that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 * Example:
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */

package _0417_pacific_atlantic_water_flow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    static final int[] DIR_X = {0, -1, 1, 0};
    static final int[] DIR_Y = {-1, 0, 0, 1};
    int[][] heights;
    int m, n;
    /* 广度优先搜索 */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);
        }
        for (int i = 0; i < n; i++) {
            bfs(0, i, pacific);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, atlantic);
        }
        for (int i = 0; i < n - 1; i++) {
            bfs(m - 1, i, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> point = new ArrayList<Integer>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    void bfs(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x, y});
        while (!que.isEmpty()) {
            int[] point = que.poll();
            int curX = point[0], curY = point[1];
            for (int i = 0; i < 4; i++) {
                int dx = curX + DIR_X[i];
                int dy = curY + DIR_Y[i];
                if (dx >= 0 && dx < m && dy >= 0 && dy < n
                        && heights[dx][dy] >= heights[curX][curY] && !ocean[dx][dy]) {
                    ocean[dx][dy] = true;
                    que.offer(new int[]{dx, dy});
                }
            }
        }
    }

    /* 深度优先搜索 */
/*
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        for (int i = 0; i < n - 1; i++) {
            dfs(m - 1, i, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> point = new ArrayList<Integer>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    void dfs(int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) {
            return;
        }
        ocean[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + DIR_X[i];
            int newY = y + DIR_Y[i];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n
                    && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, ocean);
            }
        }
    }
 */
}

