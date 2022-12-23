/**
 * Given an integer array nums,
 * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */

package _0283_move_zeroes;

class Solution {
    /* 双指针 */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}