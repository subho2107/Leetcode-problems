from typing import List
import collections as coll
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        hashP = coll.Counter(p)
        startingIndices = []
        tempHash = None
        lenOfS = len(s)
        lenOfP = len(p)
        for pos in range(0, lenOfS-lenOfP+1):
            if pos == 0:
                tempHash = coll.Counter(s[0:lenOfP])
            else:
                tempHash[s[pos-1]]-=1
                tempHash[s[pos+lenOfP-1]] += 1
            if len(hashP-tempHash) == 0:
                startingIndices.append(pos)
        return startingIndices

