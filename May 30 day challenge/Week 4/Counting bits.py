from typing import List
import math
class Solution:
    def countBits(self, num: int) -> List[int]:
        arr = [0, 1, 1, 2, 1]
        if num < len(arr):
            return arr[:num+1]
        extraPos = 1
        pos = 5
        while True:
            if math.ceil(math.log2(pos)) == math.floor(math.log2(pos)):
                extraPos = 0
            arr.append(arr[extraPos]+1)
            if num < len(arr):
                return arr[:num + 1]

            pos += 1
            extraPos += 1

t = int(input())
for _ in range(t):
    Solution().countBits(int(input()))

