322. Coin Change
  
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

Solutions:

1. Greedy Approach: 

Considering Greedy Approach initially, it doesnot give solution in all the cases. 
Case 1: It gives optimal solution in the case : Coins = [1,2,5] and sum = 11  (TotalCoins = 3)
Case 2: It gives a non-optimal solution in the case : Coins = [1,4,6] sum = 9 
Case 3: it gives a no solution in the case although the solution exists : Coins = [2,5] sum = [6]

Thus, moving on to the next approach as the greedy doesn't work in all the cases: 

2. Exhaustive Approach: 

// This gives the solution but throws a TLE.
//The time complexity is exponential here. 
//As there are 2 choices whether to choose the particular coin/not choose the particular coin. So it is 2^.
class Solution {
    //Tc: O(2^(m+n)) where m = no.of coins and n = amount
    public int coinChange(int[] coins, int amount) {
        return helper(coins, 0, amount, 0); //Calling the helper function to return the minCoins
        
    }
     public int helper(int[] coins, int index, int amount, int minCoins) //helper function takes in input 
                                                                         //coins array, the current index, amount is the current amount and finally minCoins
    {
        if(amount == 0) return minCoins;
        if(amount < 0 || index == coins.length) return -1;

        //If I choose the coin at ith index
        int case1 = helper(coins, index, amount - coins[index], minCoins+1);
        //If I do not choose the coin at ith index
        int case2 = helper(coins, index+1, amount, minCoins);

        //Check if any of the cases give a null solution

        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
}



3. Using Bottom Up DP Approach:

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        for(int j = 1; j < dp[0].length ; j++)
        {
            dp[0][j] = 99999;
        }

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }

        if(dp[m][n] >= 99999) return -1;
        return dp[m][n];
