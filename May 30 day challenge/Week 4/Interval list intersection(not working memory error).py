from typing import List
class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        if len(A) == 0 or len(B) == 0:
            return []
        length = ((max(B[-1][-1], A[-1][-1])+1)*2)+1
        arr = [0]*length
        def initArray(arr, intervArr):
            for interval in intervArr:
                arr[interval[0]*2] += 1
                arr[interval[1]*2 + 1] -= 1
        initArray(arr, A)
        initArray(arr, B)
        for pos in range(1, length):
            arr[pos] += arr[pos-1]
        commonInterv = []
        pos = 0
        while pos < length:
            if arr[pos] == 2:
                start = pos // 2
                end = pos // 2
                if arr[pos + 1] == 2:
                    while pos < length and arr[pos] == 2:
                        pos+=1
                    pos-=1
                    if pos&1:
                        pos -= 1
                    end = pos//2
                commonInterv.append([start, end])
                pos += 1
            pos+=1
        return commonInterv
print(Solution().intervalIntersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]]))

