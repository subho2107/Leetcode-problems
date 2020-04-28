import bisect


class Solution:
    def isHappy(self, n: int) -> bool:
        arr = []
        while True:
            sumPow = 0
            dup = n
            while dup != 0:
                rem = dup % 10
                sumPow += rem * rem
                dup //= 10
            n = sumPow
            if n == 1:
                return True
            pos = bisect.bisect_left(arr, n)
            if pos < len(arr) and arr[pos] == n:
                return False
            arr.append(n)

obj = Solution()
num = int(input())
print(obj.isHappy(num))
