from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        arr = [[0]*(len(coins)+1) for _ in range(amount+1)]
        arr[0][0] = 1
        for col in range(1, len(coins)+1):
            arr[0][col] = 1
        for row in range(1, len(arr)):
            for col in range(1, len(arr[0])):
                arr[row][col] = arr[row][col-1]
                if coins[col-1] <= row:
                    extra = row-coins[col-1]
                    arr[row][col] += arr[extra][col]
        return arr[-1][-1]
print(Solution().change(10, [10]))