from typing import List
class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        length = len(s)
        for query in shift:
            leftOrRight = query[0]
            noOfShifts = query[1]
            if leftOrRight == 0:
                s = s[noOfShifts:] + s[0:noOfShifts]
            else:
                s = s[length - noOfShifts:] + s[0: length - noOfShifts]
        return s

s = input()
arr = []
while True:
    temp = input()
    if not temp:
        break
    arr.append(list(map(int, temp.rstrip().split())))
print(Solution().stringShift(s, arr))