/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both
 * arrays, and you may return the result in any order.
 * Example:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */

package _0350_intersection_of_two_arrays_ii;

import java.util.Arrays;

class Solution {
    /* 双指针 */
/*
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length, n = nums2.length;
        int[] intersection = new int[Math.min(m, n)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                ++index1;
            }
            else if (nums1[index1] > nums2[index2]) {
                ++index2;
            }
            else {
                intersection[index++] = nums1[index1++];
                ++index2;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
 */
    /* 哈希表 */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hashmap = new int[1001];
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        for (int num1 : nums1) {
            hashmap[num1]++;
        }
        int i = 0;
        for (int num2 : nums2) {
            if (hashmap[num2] > 0) {
                intersection[i++] = num2;
                hashmap[num2]--;
            }
        }
        return Arrays.copyOfRange(intersection, 0, i);
    }
}



