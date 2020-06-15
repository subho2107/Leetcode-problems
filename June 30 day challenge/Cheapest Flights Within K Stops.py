from typing import List
import collections
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        visited = collections.defaultdict(float('inf'))
        vertices = collections.defaultdict(list)
        for source, destination, price in flights:
            vertices[source].append((destination, price))
        stack = collections.deque([(src, -1, 0)])
        while len(stack) != 0:
            currStop, previousStops, presentCost = stack.popleft()
            if currStop == dst or previousStops == K:
                continue
            for neighbour, priceEdge in vertices[currStop]:
                if visited[neighbour] > presentCost+priceEdge:
                    visited[neighbour] = presentCost+priceEdge
                else:
                    continue
                stack.append((neighbour, previousStops+1, presentCost+priceEdge))
        return visited[dst] if visited[dst] != float('inf') else -1