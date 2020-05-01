import random
from typing import List
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candiesToGive = [1]*len(ratings)
        for pos in range(1, len(ratings)):
            if ratings[pos] > ratings[pos-1]:
                candiesToGive[pos]  = candiesToGive[pos-1] + 1
        # print(candiesToGive)
        for pos in range(len(ratings)-2, -1, -1):
            if ratings[pos] > ratings[pos+1] and candiesToGive[pos] <= candiesToGive[pos+1]:
                candiesToGive[pos] = candiesToGive[pos+1] + 1
        # print(candiesToGive)
        return sum(candiesToGive)

obj = Solution()
t = int(input())
for _ in range(t):
    # arr = []
    # for pos in range(random.randrange(0, 6)):
    #     arr.append(random.randrange(1,10))
    arr = list(map(int, input().rstrip().split()))
    # print(arr)
    minCandies = obj.candy(arr)
    print(minCandies)

'''
1 3 5 8
5 3 2 9 7
'''