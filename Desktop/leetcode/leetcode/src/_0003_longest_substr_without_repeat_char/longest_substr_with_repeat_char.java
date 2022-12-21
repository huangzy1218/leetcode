/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
package _0003_longest_substr_without_repeat_char;

import java.util.HashSet;
import java.util.Set;

class Solution {
    /* 滑动窗口 */
/*
    public int lengthOfLongestSubstring(String s) {
        Set<Character> lookup = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            if (!lookup.contains(s.charAt(right))) {
                lookup.add(s.charAt(right++));
            } else {
                lookup.remove(s.charAt(left++));
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
*/
    /* 哈希 */
    public int lengthOfLongestSubstring(String s) {
        int[] lookup = new int[128];
        int len = s.length(), maxLength = 0;
        int left = 0, right;
        for (int i = 0; i < 128; i++) {
            lookup[i] = -1;
        }
        for (right = 0; right < len; right++) {
            int index = s.charAt(right);
            left = Math.max(left, lookup[index] + 1);
            maxLength = Math.max(maxLength, right - left + 1);
            lookup[index] = right;
        }
        return maxLength;
    }
}
