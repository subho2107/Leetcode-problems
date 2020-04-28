class Solution:
    def usingDp(self, s, dictOfWays):
        if s == "":
            return 1
        elif s in dictOfWays:
            return dictOfWays[s]
        sub = s[0]
        res = 0
        if sub != "0":
            res = self.usingDp(s[1:], dictOfWays)
        
        res2 = 0
        if len(s) >= 2:
            sub2 = s[0:2]
            if int(sub2) <= 26:
                res2 = self.usingDp(s[2:], dictOfWays)
        dictOfWays[s] = res + res2
        return res + res2
        


    def numDecodings(self, s: str) -> int:
        if len(s) == 1 and s != "0":
            return 1
        elif s == "" or s== "0":
            return 0
        dictOfWays = {}
        ways = self.usingDp(s, dictOfWays)
        return ways

obj = Solution()
print(obj.numDecodings(input()))
