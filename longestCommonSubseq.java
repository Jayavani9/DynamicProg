//https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1?page=1&company[]=Amazon&category[]=Dynamic%20Programming&sortBy=

class Solution {
    // Function to find the length of longest common subsequence in two strings.
    //Tc: O(m*n)  Sc: O(m*n)
    static int lcs(int n, int m, String str1, String str2) {

        int[][] dp = new int[n + 1][m + 1];

  
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

       
        return dp[n][m];
    }
}
