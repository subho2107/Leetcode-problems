from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        sumNum = 0
        for pos in range(0, len(nums)):
            sumNum += nums[pos]
            nums[pos] = sumNum
        self.arr = nums[:]

    def sumRange(self, i: int, j: int) -> int:
        if i == 0:
            return self.arr[j]
        else:
            return self.arr[j] - self.arr[i-1]

print("Enter val of list")
arr = list(map(int, input().rstrip().split()))
print("Enter i and j")
start = int(input())
end = int(input())
obj = NumArray(arr)
sumForRange = obj.sumRange(start, end)
print(sumForRange)