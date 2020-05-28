import collections
from typing import List
class Solution:
    def possibleBipartition(self, N: int, dislikes: List[List[int]]) -> bool:
        dislikeGraph = collections.defaultdict(list)
        for person1, person2 in dislikes:
            dislikeGraph[person1].append(person2)
            dislikeGraph[person2].append(person1)
        coloringList = {}
        def dfs(node, color = 0):
            if node in coloringList:
                return coloringList[color] == color
            coloringList[node] = color
            return all(dfs(neighbour, color^1) for neighbour in dislikeGraph[node])
        return all(dfs(node) for node in range(1, N+1) if node not in coloringList)