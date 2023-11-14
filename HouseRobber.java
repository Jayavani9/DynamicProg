198. House Robber
  
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you 
from robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Solutions

  1. Exhaustive Approach: 

/*
class Solution {
  //Tc: O(2^n)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return helper(nums, 0, 0);
      
    }

    private int helper(int[] nums, int index, int amount)
    {
        //base case
        if(index >= nums.length) return amount;
        //logic
        //If we want to select the num
        int case1 = helper(nums, index+2, amount+nums[index]);
        // Don't want to select the num
        int case2 = helper(nums, index+1, amount);

        return Math.max(case1, case2);
    }
}
*/



        

