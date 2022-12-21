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
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
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
}
