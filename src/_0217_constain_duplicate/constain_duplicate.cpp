/**
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
*/

class Solution
{
public:
    /* 集合 */
    bool containsDuplicate(vector<int>& nums)
    {
        unordered_set<int> s;
        for (int num : nums)
        {
            if (s.find(num) != s.end())
                return true;
            s.insert(num);
        }
        return false;
    }
};