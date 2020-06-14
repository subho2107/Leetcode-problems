class Solution(object):
    def largestDivisibleSubset(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        nums.sort()
        dp = [(0,0)]*length
        dp[0] = (1, 0)#(cnt of such values, pos of last value before it that divides it)
        maxVal, maxPos = 1, 0
        for pos in range(length):
            maxPair = max((dp[pos2]+1, pos2) for pos2 in range(pos+1) if nums[pos]%nums[pos2] ==0)
            dp[pos] = maxPair
            if dp[pos][0] > maxVal:
                maxVal = dp[pos][0]
                maxPos = pos
        longestDivisibleSubset = [nums[maxPos]]
        pos = maxPos
        while pos != dp[pos][1]:
            pos = dp[pos][1]
            longestDivisibleSubset.append(nums[pos])
        return longestDivisibleSubset


print(Solution().largestDivisibleSubset([4,8,10,240]))