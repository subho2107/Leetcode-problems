class Solution:
    def firstUniqChar(self, s: str) -> int:
        hashFreq = {}
        for ch in s:
            if ch not in hashFreq:
                hashFreq[ch] = 1
            else:
                hashFreq[ch] += 1
        for ch in hashFreq:
            if hashFreq[ch] == 0:
                return s.index(ch)
        return -1
