from typing import List


class Vertex:
    def __init__(self, node):
        self.adjacent = {}
        self.id = node
        self.visited = False
        self.process = None
    def addNeighbour(self,neighbour):
        self.adjacent[neighbour] = 0
class Graph:
    def __init__(self):
        self.vertDictionary = {}
        self.noOfEdges = 0
        self.connectedComponents = 0
    def addVertex(self, node):
        self.noOfEdges += 1
        newVertex = Vertex(node)
        self.vertDictionary[node] = newVertex
    def addEdge(self, frm, to):
        if frm not in self.vertDictionary:
            self.addVertex(frm)
        if to not in self.vertDictionary:
            self.addVertex(to)
        self.vertDictionary[frm].addNeighbour(self.vertDictionary[to])
        # self.vertDictionary[to].addNeighbour(self.vertDictionary[frm])
    def hasNeighbour(self, frm, to):
        if self.getVertex(to) in self.vertDictionary[frm].adjacent:
            return True
        else:
            return False
    def getVertex(self, node):
        if node in self.vertDictionary:
            return self.vertDictionary[node]
        else:
            return None
    def hasCycle(self):
        def helperMethod(vertex):
            if vertex.visited:
                if vertex.process == "start":
                    return 1
                else:
                    return 0
            vertex.process = "start"
            vertex.visited = True
            for neighbour in vertex.adjacent:
                if helperMethod(neighbour):
                    return 1
            vertex.process = "end"
            return 0

        for vertex in self.vertDictionary:
            if self.vertDictionary[vertex].visited:
                continue
            if helperMethod(self.vertDictionary[vertex]):
                return 1
        return 0


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        G = Graph()
        for vertex in range(numCourses):
            G.addVertex(vertex + 1)

        for edge in prerequisites:
            A = edge[0]
            B = edge[1]
            G.addEdge(A, B)
        return not G.hasCycle()
n = int(input())
arr = [[1,0], [0, 1]]
print(Solution().canFinish(n, arr))