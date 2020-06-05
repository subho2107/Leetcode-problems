import os
import sys
from io import BytesIO, IOBase
import math
from typing import List


class Solution:
    def twoCitySchedCost(self, cost: List[List[int]]) -> int:
        initialCost = sum([price[0] for price in cost])
        refund = [price[1]-price[0] for price in cost]
        refund.sort()
        finalCost = initialCost + sum([cashBack for cashBack in refund[:len(refund)//2]])
        return finalCost
