def isBadVersion(version):
    pass


class Solution:

    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        left = 1
        right = n
        while left <= right:
            mid = (left+right)//2
            if isBadVersion(mid) and not isBadVersion(mid-1):
                return mid
            elif not isBadVersion(mid):
                left = mid + 1
            elif isBadVersion(mid) and isBadVersion(mid-1):
                right = mid-1
