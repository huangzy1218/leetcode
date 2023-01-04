/**
 * Given an m x n integer matrix matrix, if an element is 0,
 * set its entire row and column to 0's.
 * You must do it in place.
 * Example:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix)
    {
        int m = matrix.size(), n = matrix[0].size();
        // 由于首行首列用于存储其他信息，故设置标记单独记录
        bool row0 = false, col0 = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    if (j == 0) col0 = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) { // 注意起始位置
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
        if (row0) {
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }
    }
};