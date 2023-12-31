518. Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1

Solutions:


1. Exhaustive Approach
  
class Solution {
    //Tc: O(2^m+n) and Sc: O(n+m)
    public int change(int amount, int[] coins) {
        return helper(coins, amount,0);
        
    }

    private int helper(int[] coins, int amount, int index)
    {
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;

     //choose coin
     int case1 = helper(coins, amount-coins[index],index);
     //not choose coin
     int case2 = helper(coins, amount,index+1);
     return case1+case2;

    }
}


2. DP (Bottom Up)

 
class Solution {
    //Tc: O(m*n) and Sc: O(m*n) as we are using a dp array with size (m+1)*(n+1)
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;
        int m = coins.length;
        int n = amount;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1 ; i < dp.length; i++)
        {
            for(int j = 0 ; j < dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp [i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

