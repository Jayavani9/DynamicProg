//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?page=1&company%5B%5D=Amazon&category%5B%5D=Dynamic%2520Programming&sortBy=

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         //Tc: O(N*W)  Sc: O(N*W)
         int[][] dp = new int[n+1][W+1];
         for(int i = 0; i <= n; i++)
         {
             for(int w = 0; w <= W; w++)
             {
                 if (i == 0 || w == 0) {
                     dp[i][w] = 0;
                 } else if (wt[i - 1] <= w) {
                     dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                 } else {
                     dp[i][w] = dp[i - 1][w];
                 }
             }
         }
         
         return dp[n][W];
    } 
}
