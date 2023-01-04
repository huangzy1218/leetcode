/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 * Example:
 * Input: x = 123
 * Output: 321
 */
package _0007_reverse_integer;

class Solution {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int)n == n ? (int)n : 0;
    }
}
