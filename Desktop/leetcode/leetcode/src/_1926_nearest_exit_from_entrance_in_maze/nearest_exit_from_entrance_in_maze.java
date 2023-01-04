/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column
 * of the cell you are initially standing at.
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot
 * step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell
 * that is at the border of the maze. The entrance does not count as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 * Example:
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 */

package _1926_nearest_exit_from_entrance_in_maze;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = maze.length, n = maze[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;
        while (!que.isEmpty()) {
            int sz = que.size();
            step++;
            for (int i = 0; i < sz; i++) {
                int[] point = que.poll();
                for (int[] dir : DIRS) {
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == '.') {
                        if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                            return step;
                        }
                        maze[nx][ny] = '+'; // 标记已走
                        que.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return -1;
    }
/*
    public int nearestExit(char[][] maze, int[] entrance) {
        final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = maze.length, n = maze[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        while (!que.isEmpty()) {
            int[] point = que.poll();
            int distance = point[2];
            for (int[] dir : DIRS) {
                int nx = point[0] + dir[0];
                int ny = point[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == '.') {
                    if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) { // 到达边缘
                        return distance + 1;
                    }
                    maze[nx][ny] = '+';
                    que.offer(new int[] {nx, ny, distance + 1});
                }
            }
        }
        return -1;
    }
 */
}
