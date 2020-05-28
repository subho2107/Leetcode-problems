from typing import List
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dpMatrix = [[0]*cols for _ in range(rows)]
        answer = 0
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == '1':
                    dpMatrix[row][col] = 1
                    if row > 0 and col > 0:
                        dpMatrix[row][col] += min(dpMatrix[row-1][col], dpMatrix[row][col], dpMatrix[row-1][col-1])
                    answer = max(answer, dpMatrix[row][col])
        return answer*answer