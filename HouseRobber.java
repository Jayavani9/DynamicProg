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

2. Dynamic Programming

  class Solution {
    //Tc: O(n) and Sc: O(n)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        if(n<2) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < n ; i++)
        {
            dp[i] = Math.max(dp[i-1], nums[i]+ dp[i-2]);
        }
        return dp[n-1];
    }
}


3. Optimized solution using variables

  class Solution {
    public int rob(int[] nums) {
        /Tc: O(n) and Sc: O(1)
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int dp[] = new int[n];
        if(n<2) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            int temp = curr;
            curr = Math.max(prev+nums[i], curr);
            prev = temp;
        }
        return curr;
    }
}


        

