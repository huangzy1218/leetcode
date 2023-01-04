/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * In other words, return true if one of s1's permutations is
 * the substring of s2.
 * Example:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
package _0567_permutation_in_string;

import java.util.Arrays;

class Solution {
    /* 滑动窗口 */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n)
            return false;
        int[] dirs = new int[26];
        for (int i = 0; i < m; i++) {
            dirs[s1.charAt(i) - 'a']--; // 表示此时不同元素数 -1
            dirs[s2.charAt(i) - 'a']++;
        }
        int diff = 0; // 差异度
        for (int dir : dirs) {
            if (dir != 0)  diff++;
        }
        if (diff == 0)
            return true;
        for (int i = m; i < n; i++) {
            int current = s2.charAt(i) - 'a';
            int origin = s2.charAt(i - m) - 'a';
            if (current == origin) // 两字符相同
                continue;
            if (dirs[current] == 0) // 已存在，差异度 + 1
                diff++;
            dirs[current]++;
            if (dirs[current] == 0) // 修改后匹配，差异度 -1
                diff--;
            if (dirs[origin] == 0)
                diff++;
            dirs[origin]--;
            if (dirs[origin] == 0)
                diff--;
            if (diff == 0)
                return true;
        }
        return false;
    }
/*
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n)
            return false;
        int[] dir1 = new int[26];
        int[] dir2 = new int[26];
        for (int i = 0; i < m; i++) {
            dir1[s1.charAt(i) - 'a']++;
            dir2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(dir1, dir2))
            return true;
        for (int i = m; i < n; i++) {
            dir2[s2.charAt(i) - 'a']++;
            dir2[s2.charAt(i - m) - 'a']--;
            if (Arrays.equals(dir1, dir2))
                return true;
        }
        return false;
    }
 */
}
