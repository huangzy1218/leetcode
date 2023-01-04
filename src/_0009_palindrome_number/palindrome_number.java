/**
 * Given an integer x, return true if x is a palindrome,
 * and false otherwise.
 * Example:
 * Input: x = -121
 * Output: false
 */
package _0009_palindrome_number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) // 注意顺序
            return true;
        if (x < 0 || x % 10 == 0)
            return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
