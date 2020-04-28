from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        length = len(nums)
        if length == 0:
            return 0
        elif length == 1:
            return nums[0]
        elif length == 2:
            return max(nums[0], nums[1])
        dictOfMoney = {0:nums[0],1:max(nums[0], nums[1])}
        for pos in range(2, length):
            dictOfMoney[pos] = max(dictOfMoney[pos-2] + nums[pos], dictOfMoney[pos-1])
        return dictOfMoney[length-1]


obj = Solution()
print("Enter val of list")
arr = list(map(int, input().rstrip().split()))
num = obj.rob(arr)
print(num)