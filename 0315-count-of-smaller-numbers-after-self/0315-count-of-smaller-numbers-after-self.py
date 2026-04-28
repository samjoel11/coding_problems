class SegmentTree:
    class Node:
        def __init__(self, l, r):
            self.l = l
            self.r = r
            self.sum = 0
            self.lChild = None
            self.rChild = None
    
    def __init__(self, nums):
        self.root = self._build(nums, 0, len(nums) - 1)
    
    def _build(self, nums, l, r):
        node = self.Node(l, r)
        
        if l == r:
            node.sum = nums[l]
            return node
        
        mid = (l + r) // 2
        node.lChild = self._build(nums, l, mid)
        node.rChild = self._build(nums, mid + 1, r)
        node.sum = node.lChild.sum + node.rChild.sum
        
        return node
    
    def _point_update(self, node, index, value):
        if node.l == node.r:
            node.sum = value
            return
        
        mid = (node.l + node.r) // 2
        if index <= mid:
            self._point_update(node.lChild, index, value)
        else:
            self._point_update(node.rChild, index, value)
        node.sum = node.lChild.sum + node.rChild.sum
    
    def _range_query(self, node, l, r):
        if l > node.r or r < node.l:
            return 0
        
        if l <= node.l and r >= node.r:
            return node.sum
        
        return self._range_query(node.lChild, l, r) + self._range_query(node.rChild, l, r)
    
    def update(self, index, val):
        self._point_update(self.root, index, val)
    
    def rangeQuery(self, left, right):
        return self._range_query(self.root, left, right)

class Solution:
    def valueToIndexMap(self, input):
        sorted_input = sorted(set(input))
        return {val: i for i, val in enumerate(sorted_input)}
    
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0] * n
        
        compressed = self.valueToIndexMap(nums)
        unique_count = len(compressed)
        
        freq = [0] * unique_count
        st = SegmentTree(freq)
        
        for i in range(n - 1, -1, -1):
            compressed_index = compressed[nums[i]]
            
            if compressed_index > 0:
                result[i] = st.rangeQuery(0, compressed_index - 1)
            
            freq[compressed_index] += 1
            st.update(compressed_index, freq[compressed_index])
        
        return result