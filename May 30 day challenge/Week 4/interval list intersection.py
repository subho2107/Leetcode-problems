from typing import List
class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        commonInterv = []
        posofA, posOfB = 0, 0
        while posofA < len(A) and posOfB < len(B):
            start = max(A[posofA][0], B[posOfB][0])
            end = min(A[posofA][1], B[posOfB][1])
            if start <= end:
                commonInterv.append([start, end])
            if A[posofA][1] < B[posOfB][1]:
                posofA += 1
            else:
                posOfB += 1
        return commonInterv
