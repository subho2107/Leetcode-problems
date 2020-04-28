class Solution:
    def longestValidParentheses(self, s: str) -> int:
        length = len(s)
        dpArr = [0]*length
        maxLen = 0
        for pos in range(1,length):
            if s[pos] == ')':
                if s[pos-1] == '(':
                    dpArr[pos] = dpArr[pos-2] + 2
                elif pos - dpArr[pos-1] - 1 >= 0  and s[pos - dpArr[pos-1] - 1] == '(':
                    dpArr[pos] = dpArr[pos-1] + 2 + (dpArr[pos - dpArr[pos-1] - 2] if (pos - dpArr[pos-1] >= 2) else 0)
                maxLen = max(maxLen, dpArr[pos])
        return maxLen

obj = Solution()
s = input()
cnt = obj.longestValidParentheses(s)
print(cnt)
