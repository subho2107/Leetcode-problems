class Solution:
    def sumOfNums(self, num):
        sumNum = 0
        while num != 0:
            sumNum += num % 10
            num //= 10
        return sumNum
    def removeZero(self, num):
        if num % 10 != 0:
            return num
        else:
            while(True):
                rem = num % 10
                if rem != 0:
                    return num
                num //= 10
            return num
    def countLargestGroup(self, n: int) -> int:
        dictOfNums = {}
        dictOfSum = {}
        # for num in range(1, 10):
        #     dictOfNums[num] = []
        
        for num in range(1, n+1):
            zeroNotForm = self.removeZero(num)
            sumOfNum = 0
            if zeroNotForm == num:
                sumOfNum = self.sumOfNums(num)
                dictOfSum[num] = sumOfNum
            else:
                sumOfNum = dictOfSum[zeroNotForm]
            if sumOfNum in dictOfNums:
                dictOfNums[sumOfNum].append(num)
            else:
                dictOfNums[sumOfNum] = [num]
        dictOfLength = {}
        maxlen = 0
        for arr in dictOfNums.values():
            
            length = len(arr)
            if length > maxlen:
                maxlen = len(arr)
            if length in dictOfLength:
                dictOfLength[length] += 1
            else:
                dictOfLength[length] = 1
        return dictOfLength[maxlen]
            
obj = Solution()
n = int(input())
print(obj.countLargestGroup(n))