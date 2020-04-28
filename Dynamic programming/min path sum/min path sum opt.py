from typing import List
class Solution:
    def minPathSum(self, grid:List[List[int]])->int:
        dp = grid [:][:]
        rowMax = len(grid)
        colMax = len(grid[0])
        for pos in range(1, rowMax):
            dp[pos][0] += dp[pos-1][0]
        for pos in range(1, colMax):
            dp[0][pos] += dp[0][pos-1]
        for row in range(1, rowMax):
            for col in range(1, colMax):
                dp[row][col] = min(dp[row-1][col], dp[row][col-1])+grid[row][col]
        return dp[-1][-1]

obj = Solution()
arr = []
n = int(input())
for _ in range(n):
    arr.append(list(map(int, input().rstrip().split())))
print(arr)
res = obj.minPathSum(arr)
print(res)