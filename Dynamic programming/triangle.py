from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        rowMax = len(triangle)
        present = 0
        for row in range(rowMax-2, -1, -1):
            for col in range(len(triangle[row])):
                triangle[row][col] += min(triangle[row+1][col], triangle[row+1][col+1])
            
        return triangle[0][0]


obj = Solution()
num = int(input())
print(obj.minimumTotal([list(map(int, input().rstrip().split())) for _ in range(num)]))