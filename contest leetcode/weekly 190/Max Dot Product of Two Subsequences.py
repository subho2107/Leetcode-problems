from typing import List
class Solution:
    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        dp = [[-999999999]*(len(nums1)+1) for _ in range(len(nums2)+1)]
        for row in range(1,len(nums2)+1):
            for col in range(1, len(nums1)+1):
                dp[row][col] = max(dp[row-1][col], dp[row][col-1], max(dp[row-1][col-1], 0)+nums1[col-1]*nums2[row-1])
        return dp[-1][-1]
a = list(map(int, input().rstrip().split()))
b = list(map(int, input().rstrip().split()))
print(Solution().maxDotProduct(a, b))

