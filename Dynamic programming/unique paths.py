class Solution:
    def optimizeByDP(self, grid, dictOfTups, presRow, presCol):
        maxRow, maxCol = len(grid)-1, len(grid[0])-1
        key = (presRow, presCol)
        if key in dictOfTups:
            return dictOfTups[key]
        if presRow > maxRow or presCol > maxCol:
            return 0
        elif presRow==maxRow and presCol==maxCol:
            return 1
        down = self.optimizeByDP(grid, dictOfTups, presRow+1, presCol)
        right = self.optimizeByDP(grid, dictOfTups, presRow, presCol+1)
        dictOfTups[key] = down + right
        # print(dictOfTups)
        return dictOfTups[key]
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[0]*m for _ in range(n)]
        dictOfTups = {}
        return self.optimizeByDP(grid, dictOfTups, 0, 0)
        
obj = Solution()
m = int(input())
n = int(input())
res = obj.uniquePaths(m, n)

print(res)