import bisect
class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        arr = [0, 1]
        present = 1
        while present <= k:
            arr.append(arr[-1]+arr[-2])
            present = arr[-1]
        arr.pop()
        cnt = 1
        # print(arr)
        k -= arr[-1]
        # print(k)
        while k != 0:
            pos = bisect.bisect(arr,k) - 1
            if k - arr[pos] < 0:
                arr = arr[0:pos]
                continue
            k -= arr[pos]
            cnt += 1
        return cnt

obj = Solution()
print(obj.findMinFibonacciNumbers(int(input())))
