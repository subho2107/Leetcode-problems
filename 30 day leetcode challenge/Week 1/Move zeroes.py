from typing import List


def moveZeroes(nums: List[int]) -> None:
    posOfZeroes = []
    for pos in range(len(nums)):
        num = nums[pos]
        if num == 0:
            posOfZeroes.append(pos)
    cntzero = len(posOfZeroes)
    cnt = 0
    for pos in posOfZeroes:
        nums.pop(pos-cnt)
        cnt += 1
    nums += [0] * cntzero

nums = list(map(int, input().rstrip().split()))
moveZeroes(nums)
print(nums)