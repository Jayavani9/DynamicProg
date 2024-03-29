70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


//Exhaustive Approach
class Solution {
    public int climbStairs(int n) {
        //Tc: O(2^n) Sc: O(n)
        return helper(0,n);
        
    }

  private int helper(int currentStep, int targetStep) {

        if (currentStep == targetStep) {
            return 1;
        }

  
        if (currentStep > targetStep) {
            return 0;
        }

  
        return helper(currentStep + 1, targetStep) + helper(currentStep + 2, targetStep);
    }
}

//DP Solution

class Solution {
    public int climbStairs(int n) {
        //Tc: O(n) Sc:O(n)
        if(n==1) return 1;

        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n ; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

//Using Fibonacci seq

class Solution {
    public int climbStairs(int n) {
        //Tc: O(n)  Sc: O(1)
        if(n==1) return 1;

        int fir = 1;
        int sec = 2;
        for(int i = 3; i <=n; i++)
        {
            int thr = fir + sec;
            fir = sec;
            sec = thr;
        }
      return sec;
    }
}
