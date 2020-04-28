class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        def getMSB(num):
            msbPos = -1
            while num>0:
                num = num >> 1
                msbPos += 1
            return msbPos
        res = 0
        while m >0 and n>0:
            msbM = getMSB(m)
            msbN = getMSB(n)
            print(msbN, msbM)
            if msbM != msbN:
                break
            temp = 1 << msbN
            res += temp
            m -= temp
            n -= temp
        return res

obj = Solution()
m = int(input())
n = int(input())
print(obj.rangeBitwiseAnd(m, n))