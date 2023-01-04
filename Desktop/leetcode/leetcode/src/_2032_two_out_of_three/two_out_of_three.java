/**
 * Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays.
 * You may return the values in any order.
 * Example:
 * Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * Output: [3,2]
 */

package _2032_two_out_of_three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[101];
        for (int num : nums1) {
            if (hash[num] == 0)
                ++hash[num]; // 该数在 nums1 已存在
        }
        for (int num : nums2) {
            if (hash[num] == 0)
                hash[num] = 2; // 该数在 nums2 已存在
            else if (hash[num] == 1) { // 在 nums1 和 nums2 均存在
                hash[num] += 2;
                ans.add(num);
            }
        }
        for (int num : nums3) {
            if (hash[num] == 1 || hash[num] == 2) { // 在 nums1 和 nums2 至少存在 1 次
                ans.add(num);
                hash[num] += 3;
            }
        }
        return ans;
    }

    /* 位运算 */
/*
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 1)); // 001
        }
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) | 2); // 010
        }
        for (int num : nums3) {
            map.put(num, map.getOrDefault(num, 0) | 4); // 100
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & v - 1) != 0) { // 判断是否含有至少两位 1 100 & 011 == 0
                ans.add(k);
            }
        }
        return ans;
    }
 */
}
