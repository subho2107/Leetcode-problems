from typing import List
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product = 1
        noOfZeroes = 0
        for num in nums:
            if num!=0:
                product *= num
            else:
                noOfZeroes += 1

        for pos in range(len(nums)):
            if nums[pos] != 0 :
                if noOfZeroes == 0:
                    nums[pos] = product // nums[pos]
                else:
                    nums[pos] = 0
            elif noOfZeroes == 1:
                nums[pos] = product
        return nums
obj = Solution()
print(obj.productExceptSelf(list(map(int, input().rstrip().split()))))
