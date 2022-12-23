/**
 * Given an integer array nums, find the subarray
 * which has the largest sum and return its sum.
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
*/

class Solution
{
public:
    int maxSubArray(vector<int>& nums)
    {
        int maxValue = nums[0];
        for (int i = 1; i < nums.size(); i++)
        {
            nums[i] = nums[i] + max(0, nums[i - 1]);
            maxValue = max(maxValue, nums[i]);
        }
        return maxValue;
    }
};