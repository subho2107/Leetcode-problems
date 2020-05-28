from typing import List
class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        dp = [[0]*(len(A)+1) for _ in range(len(B)+1)]
        for rowPos in range(1, len(dp)):
            for colPos in range(1, len(dp[0])):
                if A[colPos-1] == B[rowPos-1]:
                    dp[rowPos][colPos] = max(dp[rowPos-1][colPos], dp[rowPos][colPos-1], dp[rowPos-1][colPos-1]+1)
                else:
                    dp[rowPos][colPos] = max(dp[rowPos-1][colPos], dp[rowPos][colPos-1], dp[rowPos-1][colPos-1])
        return dp[-1][-1]
t = int(input())
for _ in range(t):
    a = list(map(int, input().strip().split()))
    b = list(map(int, input().strip().split()))
    print(Solution().maxUncrossedLines(a, b))