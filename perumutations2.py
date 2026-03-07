class perumutations2(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result=[]
        def backtrack(index):
            if index==len(nums):
                result.append(nums[:])
                return
            for i in range(index,len(nums)):
                nums[i],nums[index]=nums[index],nums[i]
                backtrack(index+1)
                nums[i],nums[index]=nums[index],nums[i]
        backtrack(0)
        set_result=set()
        for i in result:
            set_result.add(tuple(i))
        return [list(i) for i in set_result]