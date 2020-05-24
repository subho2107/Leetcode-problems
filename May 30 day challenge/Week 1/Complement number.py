class Solution:
    def findComplement(self, num: int) -> int:
        def complement(num):
            power = 0
            value = 0
            while num > 0:
                rem = num%2
                if not rem:
                    value += 1<<power
                power += 1
                num = num >> 1
            return value
        return complement(num)