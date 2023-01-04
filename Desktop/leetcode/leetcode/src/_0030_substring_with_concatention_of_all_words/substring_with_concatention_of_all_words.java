/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd",
 * and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it
 * is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * Example:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 */

package _0030_substring_with_concatention_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List subStr = new ArrayList<Integer>();
        int num = words.length;
        int strLen = s.length(), wordLen = words[0].length();
        for (int i = 0; i < wordLen; i++) { // 偏移从 0 到 wordLen - 1
            if (i + num * wordLen > strLen) // 长度不足
                break;
            Map<String, Integer> diff = new HashMap<>(); // 记录差异性
            for (int j = 0; j < num; j++) { // 依次截取 num 个单词
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                diff.put(word, diff.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                diff.put(word, diff.getOrDefault(word, 0) - 1);
                if (diff.get(word) == 0) {
                    diff.remove(word);
                }
            }
            for (int start = i; start <= strLen - num * wordLen; start += wordLen) {
                if (start != i) { // 右侧单词滑入，一次偏移一个单词长度
                    String word = s.substring(start + (num - 1) * wordLen, start + num * wordLen);
                    diff.put(word, diff.getOrDefault(word, 0) + 1);
                    if (diff.get(word) == 0) {
                        diff.remove(word);
                    }
                    // 左侧单词滑出
                    word = s.substring(start - wordLen, start);
                    diff.put(word, diff.getOrDefault(word, 0) - 1);
                    if (diff.get(word) == 0) {
                        diff.remove(word);
                    }
                }
                if (diff.isEmpty()) { // 差异度为 0，匹配成功
                    subStr.add(start);
                }
            }
        }
        return subStr;
    }
/*
    public List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, n = words[0].length();
        List sub = new ArrayList<Integer>();
        if (s.length() < m * n)
            return sub;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> temp = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String str;
        int i, j;
        for (i = 0; i <= s.length() - m * n; i++) {
            for (j = i; j < i + m * n; j += n) {
                str = s.substring(j, j + n);
                if (!map.containsKey(str))
                    break;
                temp.put(str, temp.getOrDefault(str, 0) + 1);
            }
            if (j == i + m * n && temp.equals(map)) {
                sub.add(i);
            }
            temp.clear();
        }
        return sub;
    }
 */
}
