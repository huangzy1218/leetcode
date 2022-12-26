/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown.
 * Example:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

class Solution {
public:
    vector<vector<int>> generate(int numRows)
    {
        vector<vector<int>> yanghui(numRows);
        for (int i = 0; i < numRows; i++)
            yanghui[i].resize(i + 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                yanghui[i][j] = 1;
                if (j > 0 && i > j) {
                    yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
                }
            }
        }
        return yanghui;
    }
};