/**
 * Given an integer array nums, find the subarray
 * which has the largest sum and return its sum.
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

package _0053_max_subarr;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 判断是否连续添加上一位
            nums[i] = nums[i] + Math.max(0, nums[i - 1]);
            maxValue = Math.max(nums[i], maxValue);
        }
        return maxValue;
    }
}
