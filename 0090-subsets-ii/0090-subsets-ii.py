class Solution:
    def subsetsWithDup(self, nums):
        nums.sort()
        ans = []

        def backtrack(idx, path):
            if idx == len(nums):
                ans.append(path[:])
                return

            # include
            path.append(nums[idx])
            backtrack(idx + 1, path)
            path.pop()

            # skip duplicates
            while idx + 1 < len(nums) and nums[idx] == nums[idx + 1]:
                idx += 1

            backtrack(idx + 1, path)

        backtrack(0, [])
        return ans