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
