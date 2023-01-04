/**
 * Given a string s, return the number of homogenous substrings of s.
 * Since the answer may be too large, return it modulo 109 + 7.
 * A string is homogenous if all the characters of the string are the same.
 * A substring is a contiguous sequence of characters within a string.
 * Example:
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 */
package _1759_count_number_of_homogenous_substring;

class Solution {
    public int countHomogenous(String s) {
        long homoCounts = 1;
        int record = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                record++;
            } else {
                record = 1; // 与上个字符不相同
            }
            homoCounts += record;
        }
        return (int)(homoCounts % 1000000007);
    }
}