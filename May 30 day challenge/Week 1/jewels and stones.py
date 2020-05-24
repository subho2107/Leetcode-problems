class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        stones = {}
        jewels = {}
        temp = iter(J)
        J = dict(zip(temp, temp))
        for s in S:
            if s in stones:
                stones[s] += 1
            else:
                stones[s] = 1
        cnt = 0
        for s in stones:
            if s in jewels:
                cnt += jewels[s]
        return cnt