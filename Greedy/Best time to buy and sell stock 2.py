from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        prices = [prices[0]+1] + prices + [0]
        pos = 1
        profit = 0
        while pos < len(prices)-1:
            if prices[pos] <= prices[pos-1] and prices[pos] < prices[pos+1]:
                costPrice = prices[pos]
                sellingPrice = 0
                pos += 1
                while pos < len(prices)-1:
                    if prices[pos] > prices[pos-1] and prices[pos] >= prices[pos+1]:
                        sellingPrice = prices[pos]
                        pos += 1
                        break
                    pos += 1
                profit += sellingPrice - costPrice
            else:
                pos += 1
        return profit

obj = Solution()
arr = list(map(int, input().rstrip().split()))
print(obj.maxProfit(arr))