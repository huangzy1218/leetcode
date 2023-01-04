/**
 * Given an integer array nums, return true if any value appears
 * at least twice in the array, and return false if every element is distinct.
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
 */

package _0217_constain_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
