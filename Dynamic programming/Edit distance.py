class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if len(word1) < len(word2):
            word1, word2 = word2, word1
        dup = word2
        pos = 0
        while not dup and not word1:
            if word1[pos] == dup[0]:
                dup = dup[1:]
            pos += 1
        dup2 = word2
        pos = len(word1)
        while not dup2 and not word1:
            if word1[pos] == dup2[0]:
                dup2 = dup2[1:]
            pos -= 1


