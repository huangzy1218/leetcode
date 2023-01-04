/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * Example:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */

package _0977_squares_of_a_sorted_arr;

class Solution {
    /* 双指针 */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] squares = new int[n];
        int left = 0, right = n - 1;
        int k = n - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                squares[k--] = nums[left] * nums[left++];
            } else {
                squares[k--] = nums[right] * nums[right--];
            }
        }
        return squares;
    }
}
