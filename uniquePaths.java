62. Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28

Solution:

1. Exploring all the possible ways (Throws TLE)
 class Solution {  
    //Tc: O(2^m*n) 
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
        
    }

    private int helper(int i, int j, int m, int n)
    {
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return 1;
        return helper(i,j+1,m,n) + helper(i+1,j,m,n);
    }
}

2. Dynamic Programming 

 class Solution {
  //Tc: O(m*n) Sc: O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        helper(grid, m, n);
        return grid[0][0];
    }

     private void helper(int[][] grid, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
                }
            }
        }
    }
}
