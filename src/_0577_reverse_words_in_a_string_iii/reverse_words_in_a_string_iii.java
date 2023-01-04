/**
 * Given a string s, reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 * Example:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
package _0577_reverse_words_in_a_string_iii;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            if (i != 0)
                res.append(" ");
            res.append(new StringBuffer(words[i]).reverse().toString());
        }
        return res.toString();
    }
/*
    public String reverseWords(String s) {
        char[] result = s.toCharArray();
        int i = 0, j = 0;
        while (j < result.length) {
            if (result[j] == ' ') {
                reverseWord(result, i, j - 1);
                i = j + 1;
                j = i;
            }
            j++;
        }
        reverseWord(result, i, result.length - 1);
        return new String(result);
    }

    private void reverseWord(char[] word, int i, int j) {
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }
*/
}
