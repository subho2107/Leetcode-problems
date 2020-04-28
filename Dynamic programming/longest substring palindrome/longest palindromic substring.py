class Solution:
    def isPalin(self, string):
        if string[::-1] == string:
            return True
        else:
            return False
        
    def longestPalindrome(self, s: str) -> str:
        maxLen = 0
        result = ""
        length = len(s)
        if length == 1:
            return s
        for start in range(0, length):
            for end in range(start+1, length):
                word = s[start:end+1]
                tempLen = end - start + 1
                if self.isPalin(word) and tempLen > maxLen:
                    maxLen = tempLen
                    result = word
                    break
        if result == "":
            return s[0]
        return result

obj = Solution()
string = input()
result = obj.longestPalindrome(string)
print(result)

