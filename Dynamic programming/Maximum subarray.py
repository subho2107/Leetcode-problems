from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        for pos in range(0, len(nums)):
            largestSumTillPos = max(nums[pos], nums[pos]+nums[pos-1])
            nums[pos] = largestSumTillPos
        return max(nums)

if __name__ == "__main__":
    obj = Solution()
    print("Enter the elements of the list")
    arr = list(map(int,input().rstrip().split()))
    maxSum = obj.maxSubArray(arr)
    print(maxSum)

