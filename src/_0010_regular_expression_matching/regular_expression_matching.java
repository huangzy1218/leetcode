/**
 * Given an input string s and a pattern p,
 * implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Example:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 */

package _0010_regular_expression_matching;

class Solution {
    /* 递归 */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        boolean firstMatch =
                !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // * 匹配 0 次或 1 次
        // 匹配 0 次即跳过前两个字符，匹配 1 次则跳过 s 的第一个字符，即 *c 匹配 c 1 次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            // 正常匹配
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /* 动态规划 */
/*
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') { // 匹配 0 或多个
                    dp[i][j] = dp[i][j - 2]; // 舍弃前两个字符，匹配 0 次
                    if (firstMatch(s, p, i, j - 1)) { // 尝试匹配 * 的前一个字符
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // j 和前一个字符匹配
                    }
                } else {
                    if (firstMatch(s, p, i, j)) // 正常匹配
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    private boolean firstMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.')
            return true;
        return p.charAt(j - 1) == s.charAt(i - 1);
    }
 */
}


