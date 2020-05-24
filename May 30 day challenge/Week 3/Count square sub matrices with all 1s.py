from typing import List
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dpMatrix = [[0] * cols for _ in range(rows)]
        answer = 0
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 1:
                    dpMatrix[row][col] = 1
                    if row > 0 and col > 0:
                        dpMatrix[row][col] += min(dpMatrix[row - 1][col], dpMatrix[row][col-1],
                                                  dpMatrix[row - 1][col - 1])
                    if dpMatrix[row][col] != 0:
                        answer += dpMatrix[row][col]
        return answer
ans = Solution().countSquares([[1,0,1],[1,1,0],[1,1,0]])
print(ans)