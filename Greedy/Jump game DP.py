from typing import List
import random
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True
        if nums[0] == 0:
            return False
        arr = [True]
        nearestTrue = len(nums)
        for pos in range(len(nums)-2, -1, -1):
            if (nums[pos] > 0) and (arr[0] is True or nums[pos] >= len(nums)-pos-1 or nums[pos] >= nearestTrue-pos):
                arr = [True] + arr
                nearestTrue = pos
            else:
                arr = [False] + arr
        # print(arr)
        return arr[0]

obj = Solution()
for _ in range(10):
    nums = []
    for _ in range(random.randint(1,9)):
        nums.append(random.randint(0,4))
    print(nums)
    possibility = obj.canJump(nums)
    print(possibility)
# for _ in range(int(input())):
#     possibility = obj.canJump(list(map(int, input().rstrip().split())))
#     print(possibility)
#[1, 0, 2, 2, 4]
# if nums[pos] >= len(nums) - pos - 1:
