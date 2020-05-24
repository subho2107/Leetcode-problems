class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        res = []
        if len(num) == k:
            return "0"
        for i in range(len(num)):
            while k and res and res[-1]>num[i]:
                res.pop()
                k -= 1
            res.append(num[i])
        while k > 0:
            res.pop()
            k -= 1
        return ' '.join(res).lstrip('0') or '0'

t = int(input())
obj = Solution()
for _ in range(t):
    num = input()
    k = int(input())
    print(obj.removeKdigits(num, k))