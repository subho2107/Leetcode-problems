class StockSpanner:

    def __init__(self):
        self.stack = []
    def next(self, price: int) -> int:
        stack = self.stack
        span = 1
        while stack and stack[-1][0] <= price:
            span += stack[-1][-1]
            stack.pop()
        self.stack.append((price, span))
        return span
obj = StockSpanner()
print(obj.next(100))
print(obj.next(80))
print(obj.next(60))
print(obj.next(70))
print(obj.next(60))
print(obj.next(75))
print(obj.next(85))