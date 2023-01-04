/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string)
 *  is '-' or '+'. Read this character in if it is either.
 *  This determines if the final result is negative or positive respectively.
 *  Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
 * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Example:
 * Input: s = "42"
 * Output: 42
 */

package _0008_string_to_integer;

class Solution {
    public int myAtoi(String s) {
        char[] integer = s.toCharArray();
        int len = integer.length;
        int i = 0;
        // 跳过前导空格
        while (i < len && integer[i] == ' ') {
            i++;
        }
        // 特判
        if (i == len) {
            return 0;
        }
        // 判断符号，只记录第一个
        int sign = 1;
        if (integer[i] == '+') {
            i++;
        } else if (integer[i] == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        // 计算数值
        while (i < len) {
            char currentChar = integer[i];
            if (currentChar < '0' || currentChar > '9')
                break;
            // 不引入 long 的越界判断
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && currentChar - '0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            } else if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && currentChar - '0' > -(Integer.MIN_VALUE % 10))) { // 取余的符号与被除数相同或为0
                return Integer.MIN_VALUE;
            }
            num = num * 10 + sign * (currentChar - '0');
            i++;
        }
        return num;
    }
}
