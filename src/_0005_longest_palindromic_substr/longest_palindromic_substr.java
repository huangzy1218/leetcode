/**
 * Given a string s, return the longest palindromic substring in s.
 * Example:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */
package _0005_longest_palindromic_substr;

class Solution {
    /* 中心扩散 */
/*
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        int maxStart = 0, maxLength = 0;
        int length = s.length();
        int left, right;
        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            int curLength = 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                curLength++;
                left--;
            }
            while (right < length && s.charAt(i) == s.charAt(right)) {
                curLength++;
                right++;
            }
            while (left >= 0 && right < length &&
                    s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                curLength += 2;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
*/
    /* 动态规划 */
    public String longestPalindrome(String s) {
        if (s.length() < 2 || s == null) {
            return s;
        }
        int maxStart = 0, maxLength = 1;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) &&
                        (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLength) {
                        maxLength = right - left + 1;
                        maxStart = left;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart + maxLength);
    }
}
