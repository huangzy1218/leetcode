/**
 * In MATLAB, there is a handy function called reshape,
 * which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * You are given an m x n matrix mat and two integers r and c
 * representing the number of rows and the number of columns of the wanted reshaped matrix.
 * The reshaped matrix should be filled with all the elements of the original matrix in the same
 * row-traversing order as they were.
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.
 * Example:
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 */

package _0566_reshape_the_matrix;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c)
            return mat;
        int[][] reshapedMat = new int[r][c];
        for (int i = 0; i < m * n; i++)
            reshapedMat[i / c][i % c] = mat[i / n][i % n];

        return reshapedMat;
    }
}