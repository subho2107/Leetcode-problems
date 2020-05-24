class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        arr = [fact for fact in range(1, num//2+1)]
        lo = 0
        hi = len(arr)-1
        while lo <= hi:
            mid = (lo+hi)//2
            if arr[mid]*arr[mid] == num:
                return True
            elif arr[mid]*arr[mid] < num:
                hi = mid-1
            else:
                lo = mid+1

        return False
