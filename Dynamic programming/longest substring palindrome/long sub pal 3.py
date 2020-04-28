class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        L = R = 0
        for i in range(n):
            l = r = i
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l - 1 > R - L + 1:
                L, R = l + 1, r - 1
                
        for i in range(n - 1):
            l, r = i, i + 1
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l - 1 > R - L + 1:
                L, R = l + 1, r - 1
                
        return s[L:R + 1]
                
obj = Solution()
string = input()
result = obj.longestPalindrome(string)
print(result)