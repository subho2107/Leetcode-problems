from typing import List
import bisect
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort()
        while len(stones) > 1:
            stone1 = stones.pop()
            stone2 = stones.pop()
            if stone2 == stone1:
                continue
            else:
                bisect.insort(stones, stone1-stone2)
        if len(stones) == 0:
            return 0
        return stones[0]

print(Solution().lastStoneWeight(list(map(int, input().rstrip().split()))))
