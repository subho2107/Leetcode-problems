class Solution:
    def isSubsequence(self, s: str = 'abc', t: str = 'ahbgdc') -> bool:
        s, t = list(s), list(t)
        posS, posT = 0, 0
        while posT < len(t) and posS < len(s):
            if s[posS] == t[posT]:
                posS+=1
                posT+=1
            else:
                posT+=1
        if posS == len(s) and posT <= len(t):
            return True
        else:
            return False
Solution().isSubsequence()