/**
 * You are given two strings word1 and word2. You want to construct a string merge in the following way:
 * while either word1 or word2 are non-empty, choose one of the following options:
 * If word1 is non-empty, append the first character in word1 to merge and delete it from word1.
 * For example, if word1 = "abc" and merge = "dv", then after choosing this operation, word1 = "bc" and merge = "dva".
 * If word2 is non-empty, append the first character in word2 to merge and delete it from word2.
 * Example:
 * Input: word1 = "cabaa", word2 = "bcaaa"
 * Output: "cbcabaaaaa"
 * Explanation: One way to get the lexicographically largest merge is:
 * - Take from word1: merge = "c", word1 = "abaa", word2 = "bcaaa"
 * - Take from word2: merge = "cb", word1 = "abaa", word2 = "caaa"
 * - Take from word2: merge = "cbc", word1 = "abaa", word2 = "aaa"
 * - Take from word1: merge = "cbca", word1 = "baa", word2 = "aaa"
 * - Take from word1: merge = "cbcab", word1 = "aa", word2 = "aaa"
 * - Append the remaining 5 a's from word1 and word2 at the end of merge.
 */
package _1754_largest_merge_of_two_strings;

class Solution {
    public String largestMerge(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder merge = new StringBuilder();
        while (index1 < word1.length() && index2 < word2.length()) {
            if (word1.charAt(index1) > word2.charAt(index2)) {
                merge.append(word1.charAt(index1++));
            } else if (word1.charAt(index1) < word2.charAt(index2)) {
                merge.append(word2.charAt(index2++));
            } else {
                if (word1.substring(index1).compareTo(word2.substring(index2)) >= 0) {
                    merge.append(word1.charAt(index1++));
                } else {
                    merge.append(word2.charAt(index2++));
                }
            }
        }
        while (index1 < word1.length()) {
            merge.append(word1.charAt(index1++));
        }
        while (index2 < word2.length()) {
            merge.append(word2.charAt(index2++));
        }
        return merge.toString();
    }
}
