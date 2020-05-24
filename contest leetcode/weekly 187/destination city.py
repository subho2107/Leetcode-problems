from typing import List


class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        city = ''
        hashFrom = {}
        for row in range(0, len(paths)):
            hashFrom[paths[row][0]] = None
        for row in range(0, len(paths)):
           if hashFrom[paths[row][-1]] not in hashFrom:
               return paths[row][-1]

