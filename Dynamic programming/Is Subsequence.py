class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s:
            return True
        elif not t:
            return False

        def usingDp(posOfS, startingPos):
            if posOfS >= length:
                return True
            pos = t.find(s[posOfS],startingPos)
            if pos != -1:
                return usingDp(posOfS+1, pos+1)
            return False

        length = len(s)
        return usingDp(0,0)





