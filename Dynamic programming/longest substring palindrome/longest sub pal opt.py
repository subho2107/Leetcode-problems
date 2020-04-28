class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if length <= 1:
            return s
        maxLen = 0
        startRes = 0
        result = ""
        dp = [[False]*length for _ in range(length)]
        for pos in range(length):
            dp[pos][pos] = True

        for start in range(length-1, -1, -1):
            for end in range(start+1, length):
                tempLen = end - start + 1
                dp[start][end] = s[start] == s[end] and (end-start == 1 or dp[start+1][end-1])
                if dp[start][end] and tempLen > maxLen:
                    maxLen = tempLen
                    startRes = start
        result = s[startRes:startRes+maxLen]
        return result

obj = Solution()
string = input()
result = obj.longestPalindrome(string)
print(result)