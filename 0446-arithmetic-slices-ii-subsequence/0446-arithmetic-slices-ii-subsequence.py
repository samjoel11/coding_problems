from collections import defaultdict
from typing import List

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n+1)]

        ans = 0

        for i in range(0,n):
            for j in range(0,i):
                diff = nums[i]-nums[j]
                count = dp[j][diff]

                ans += count

                dp[i][diff] += count + 1
        
        return ans