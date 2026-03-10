import java.util.Arrays;

class Solution {
    public int solve(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        dp[m][n] = solve(m - 1, n, dp) + solve(m, n - 1, dp);
        return dp[m][n];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m - 1, n - 1, dp);
    }
}