from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        noOfRows = len(grid)
        noOfCols = len(grid[0])

        if noOfCols*noOfRows == 1:
            return 1 if grid[0][0] == '1' else 0

        self.noOfIslands = 0

        def depthFirstSeacrch(grid, row, col):
            if row < 0 or col < 0 or row > noOfRows-1 or col > noOfCols-1 or grid[row][col] != '1':
                return

            grid[row][col] = self.noOfIslands
            depthFirstSeacrch(grid, row+1, col)
            depthFirstSeacrch(grid, row-1, col)
            depthFirstSeacrch(grid, row, col+1)
            depthFirstSeacrch(grid, row, col-1)

        for row in range(noOfRows):
            for col in range(noOfCols):
                if grid[row][col] == '1':
                    depthFirstSeacrch(grid, row, col)
                    self.noOfIslands += 1

        return self.noOfIslands

