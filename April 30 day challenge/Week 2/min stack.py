import bisect
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.queue = []
        self.sortedArr = []

    def push(self, x: int) -> None:
        self.queue.append(x)
        bisect.insort(self.sortedArr, x)

    def pop(self) -> None:
        num = self.queue.pop(0)
        self.sortedArr.remove(num)
    def top(self) -> int:
        return self.queue[0]
    def getMin(self) -> int:
        return self.sortedArr[0]

obj = MinStack()
obj.push(x)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()