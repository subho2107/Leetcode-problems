from typing import List


def maxProfit(prices: List[int]) -> int:
    dup = prices[:]
    check = False
    pos = 1
    while pos < len(prices):
        if dup[pos] > dup[pos-1]:
            dup[pos] = [dup[pos-1],pos-1]
            pos += 2
            continue
        pos += 1
    profit = 0
    arr = []
    for pos in range(1, len(prices)):
        diff = prices[pos] - dup[pos][0]
        if diff > 0 and pos > :
            profit += diff
            arr = [pos, dup[pos][1]]
    return profit

arr = list(map(int, input().rstrip().split()))
print(maxProfit(arr))