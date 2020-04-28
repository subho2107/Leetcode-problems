from typing import List
class Solution:
    rowMax, colMax = 0, 0
    def recursiveDP(self, rStart, cStart, dpDict, grid):
        # global rowMax, colMax
        # if (rStart, cStart) in dpDict:
        #         return dpDict[(rStart, cStart)]
        # elif rStart == rowMax-1:
        #     if (rStart, cStart) not in dpDict:
        #         dpDict[(rStart,cStart)] = sum(grid[rStart][cStart:])
        #     return dpDict[(rStart,cStart)]
        # elif cStart == colMax-1:
        #     if (rStart, cStart) not in dpDict:
        #         res = 0
        #         for row in range(rStart, rowMax):
        #             res += grid[row][cStart]
        #         dpDict[(rStart,cStart)] = res
        #     return dpDict[(rStart,cStart)]
        # elif rStart > rowMax-1 or cStart > colMax-1:
        #     return float("inf")
        # else:
        #     down = self.recursiveDP(rStart+1, cStart, dpDict, grid) 
        #     right = self.recursiveDP(rStart,cStart+1, dpDict, grid)
        #     dpDict[(rStart, cStart)] = min(down , right) + grid[rStart][cStart]
        #     return dpDict[(rStart, cStart)]
        global rowMax, colMax
        key = (rStart, cStart)
        if key in dpDict:
                return dpDict[key]
        if rStart == rowMax-1 and cStart == colMax-1:
           return grid[rStart][cStart]
        if rStart > rowMax-1 or cStart > colMax-1:
            return float("inf")
        down = self.recursiveDP(rStart+1, cStart, dpDict, grid) 
        right = self.recursiveDP(rStart,cStart+1, dpDict, grid)
        dpDict[key] = min(down , right) + grid[rStart][cStart]
        return dpDict[key]

    def minPathSum(self, grid:List[List[int]])->int:
        global rowMax, colMax
        dp = {}
        rowMax = len(grid)
        colMax = len(grid[0])
        return self.recursiveDP(0, 0, dp, grid)

obj = Solution()
arr = []
n = int(input())
for _ in range(n):
    arr.append(list(map(int, input().rstrip().split())))
print(arr)
res = obj.minPathSum(arr)
print(res)