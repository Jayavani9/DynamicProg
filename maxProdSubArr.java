152. Maximum Product Subarray

Given an integer array nums, find a 
subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


//Using prefix and suffix 
class Solution {
    //Tc: O(n) Sc: O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for(int i = 0; i < n; i++)
        {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}
/*
//Using 2 for loops 
class Solution {
    //Tc: O(n^2) Sc: O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            int prod = 1;
            for(int j = i; j < n; j++)
            {
                prod *= nums[j];
                ans = Math.max(prod,ans);
            }
        }
        return ans;
    }
}
*/

/* Using a 2D DP Array
//Tc: O(n^2) Sc: O(n^2)
int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];

        // Initialize diagonal where i == j
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            ans = Math.max(ans, dp[i][i]); // Update the max product initially
        }

        // Fill dp table for subarrays with more than one element
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] * nums[j];
                ans = Math.max(ans, dp[i][j]); // Update the max product
            }
        }

        return ans;

*/
