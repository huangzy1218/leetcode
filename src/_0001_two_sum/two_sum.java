package _0001_two_sum;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 */

class Solution {
    /* 二次遍历 */
/*
     public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) { // n-1: 为第 2 个数字保留一位
            for (int j = i + 1; j < n; j++) { // 二层遍历起点为 i 的下一位
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j }; // 返回下标数组
                }
            }
        }
        return null;
    }
 */
    /* 哈希表 */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        // 保存 [value,index], 通过值判断是否存在下标匹配
        for (int i = 0; i < nums.length; i++) { // 遍历数组
            if (hash.containsKey(target - nums[i])) { // 查找是否存在 target - x
                return new int[] { hash.get(target - nums[i]), i };
            }
            hash.put(nums[i], i); // 将当前元素添加至哈希表
        }
        return null;
    }
}