class Solution:
    def toDeci(self, binary):
        deci = 0
        cnt = 0
        for pos in range(len(s)-1, -1, -1):
            num = int(binary[pos])
            deci += int(pow(2, cnt)) * num
            cnt += 1
        return deci
    def numSteps(self, s: str) -> int:
        binary = s
        decimal = self.toDeci(binary)
        steps = 0
        while(decimal!=1):
            if decimal % 2 == 0:
                decimal //= 2
            else:
                decimal += 1
            steps += 1
        return steps

s = input()
print(Solution().numSteps(s))
