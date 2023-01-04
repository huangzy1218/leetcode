/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both
 * arrays, and you may return the result in any order.
 * Example:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */

class Solution {
public:
    /* 哈希表 */
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2)
    {
        vector<int> intersection;
        int hashmap[1001] = {0};
        for (int num1 : nums1)
            hashmap[num1]++;
        for (int num2 : nums2) {
            if (hashmap[num2] > 0) {
                intersection.push_back(num2);
                --hashmap[num2];
            }
        }
        return intersection;
    }
};