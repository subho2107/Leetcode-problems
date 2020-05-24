import collections as coll
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s = s2
        p = s1
        hashP = coll.Counter(p)
        tempHash = None
        lenOfS = len(s)
        lenOfP = len(p)
        for pos in range(0, lenOfS - lenOfP + 1):
            if pos == 0:
                tempHash = coll.Counter(s[0:lenOfP])
            else:
                tempHash[s[pos - 1]] -= 1
                tempHash[s[pos+lenOfP-1]] += 1
            if len(hashP - tempHash) == 0:
                return True
        return False
a = Solution().checkInclusion('ab', 'eidbooo')
print(a)