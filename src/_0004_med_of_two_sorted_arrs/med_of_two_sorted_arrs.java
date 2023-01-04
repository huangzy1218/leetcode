/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * Example:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

package _0004_med_of_two_sorted_arrs;

class Solution {
    /* 二分查找 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2; // 避免奇偶特判
        int right = (m + n + 2) / 2;
        return (getKtnNum(nums1, 0, m - 1, nums2, 0, n - 1 , left) +
                getKtnNum(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2.0;
    }

    private double getKtnNum(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 == 0)  return nums2[start2 + k - 1];
        if (len2 == 0)  return nums1[start1 + k - 1];
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(k / 2, len1) - 1;
        int j = start2 + Math.min(k / 2, len2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKtnNum(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKtnNum(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}


