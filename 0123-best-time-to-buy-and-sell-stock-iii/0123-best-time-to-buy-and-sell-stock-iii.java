class Solution {
    Integer[][][] dp;
    public int solve(int[] nums, int i, int hold, int count){
        if(count==0 || i==nums.length) return 0;

        if(dp[i][hold][count]!=null) return dp[i][hold][count];

        int ans = Integer.MIN_VALUE;
        if(hold==0){ // we can buy stock
            int buy = solve(nums, i+1, 1, count) - nums[i];
            int notBuy = solve(nums, i+1, hold, count);
            ans = Math.max(ans, Math.max(buy, notBuy));
        }else{ // we can sell curr stock
            int sell = nums[i] + solve(nums, i+1, 0, count-1);
            int notSell = solve(nums, i+1, hold, count);
            ans = Math.max(ans, Math.max(sell, notSell));
        }
        return dp[i][hold][count] = ans;
    }
    public int maxProfit(int[] nums){
        int n = nums.length;
        // dp = new Integer[n][2][3];
        // return solve(nums, 0, 0, 2);


        // Tabulation - 
        int[][][] dp = new int[n+1][2][3];
        for(int i=0; i<n; i++){
            dp[i][0][0] = 0;
            dp[i][1][0] = 0;
        }
        dp[n][0][0] = 0;
        dp[n][0][1] = 0;
        dp[n][0][2] = 0;
        dp[n][1][0] = 0;
        dp[n][1][1] = 0;
        dp[n][1][2] = 0;

        for(int i=n-1; i>=0; i--){
            for(int hold=1; hold>=0; hold--){
                for(int count=1; count<3; count++){
                    int ans = Integer.MIN_VALUE;
                    if(hold==0){
                        int buy = dp[i+1][1][count] - nums[i];
                        int notBuy = dp[i+1][hold][count];
                        ans = Math.max(ans, Math.max(buy, notBuy));
                    }else{
                        int sell = Integer.MIN_VALUE;
                        if(count-1>=0){
                            sell = nums[i] + dp[i+1][0][count-1];
                        }
                        int notSell = dp[i+1][hold][count];
                        ans = Math.max(ans, Math.max(sell, notSell));
                    }
                    dp[i][hold][count] = ans;
                }
            }
        }
        return dp[0][0][2];
    }
}