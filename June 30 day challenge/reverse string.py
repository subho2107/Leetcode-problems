from typing import List
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        for pos in range(len(s) // 2):
            s[pos], s[len(s) - pos - 1] = s[len(s) - pos - 1], s[pos]

