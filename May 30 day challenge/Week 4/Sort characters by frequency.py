from collections import Counter
class Solution:
    def frequencySort(self, s: str) -> str:
        hash = Counter(s)
        res = ""
        arr = sorted(hash, key=lambda x: hash[x], reverse=True)
        for ch in arr:
            res += ch*hash[ch]
        return res
print(Solution().frequencySort(input()))