300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing 
subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

Solution

1. Exhaustive Approach 
//Choose or not choose at each value
class Solution {
    //Tc: O(2^n) and Sc: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findLISLength(nums, 0, Integer.MIN_VALUE);
    }

    private static int findLISLength(int[] nums, int currentIndex, int prevValue) {
        if (currentIndex == nums.length) {
            return 0;
        }

        int chooseCurrent = 0;
        if (nums[currentIndex] > prevValue) {
            chooseCurrent = 1 + findLISLength(nums, currentIndex + 1, nums[currentIndex]);
        }

        int excludeCurrent = findLISLength(nums, currentIndex + 1, prevValue);

        return Math.max(chooseCurrent, excludeCurrent);
    }
        
}
