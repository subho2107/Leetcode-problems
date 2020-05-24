# cook your dish here
import collections
class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        maxLen = 0
        freq = collections.Counter(s[0:k])
        for pos in range(len(s)-k+1):
            print(s[pos:pos+k])
            print(freq)
            if pos > 0:
                freq[s[pos-1]] -= 1
                freq[s[pos+k-1]] += 1
            cnt = 0
            for ch in 'aeiou':
                if ch in freq:
                    cnt += freq[ch]
            if cnt > maxLen:
                maxLen = cnt
        return maxLen
s = input()
a = int(input())
print(Solution().maxVowels(s, a))