from typing import List
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if trust == []:
            return 1
        trustRecieved = {}
        trustGiven = {}
        for (oneWhoTrusts, oneWhoGetsTrust) in trust:
            if oneWhoTrusts  not in trustGiven:
                trustGiven[oneWhoTrusts] = 1
            else:
                trustGiven[oneWhoTrusts] += 1
            if oneWhoGetsTrust in trustRecieved:
                trustRecieved[oneWhoGetsTrust] += 1
            else:
                trustRecieved[oneWhoGetsTrust] = 1
            # print(trustRecieved, trustGiven)
        for person in trustRecieved:
            if trustRecieved[person] == N-1:
                if person not in trustGiven:
                    return person
        return -1