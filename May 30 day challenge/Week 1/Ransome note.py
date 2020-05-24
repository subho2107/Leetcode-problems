class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        def giveCount(arr):
            hashCnt = {}
            for ch in arr:
                if ch not in hashCnt:
                    hashCnt[ch] = 1
                else:
                    hashCnt[ch] += 1
            return hashCnt
        ransomeCnt = giveCount(ransomNote)
        magazineCnt = giveCount(magazine)
        for ch in ransomeCnt:
            if ch not in magazineCnt or ransomeCnt[ch] > magazineCnt[ch]:
                return False
        return True