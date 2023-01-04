/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * Example:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 */

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n)
    {
         int p = m-- + n-- - 1;
         while (m >= 0 && n >= 0) {
             nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
         }
         while (n >= 0) {
             nums1[p--] = nums2[n--];
         }
    }
};