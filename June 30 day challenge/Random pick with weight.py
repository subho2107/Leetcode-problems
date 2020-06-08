import random
from typing import List
import bisect

class Solution:

    def __init__(self, w: List[int]):
        self.arr = w
        for pos in range(1, len(self.arr)):
            self.arr += self.arr[pos-1]

    def pickIndex(self) -> int:
        val = random.randrange(1, self.arr[-1]+1)
        return bisect.bisect(self.arr,val)


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()