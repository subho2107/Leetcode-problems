class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        dictOfFreq = {}
        for char in s:
            if char in dictOfFreq:
                dictOfFreq[char] += 1
            else:
                dictOfFreq[char] = 1
        checkAll1 = True
        for char in dictOfFreq:
            freq = dictOfFreq[char]
            if freq != 1:
                checkAll1 = False
                break
        if checkAll1:
            return True
        else:
            print("sakldbj")
            check = True
            checkFor1 = False
            toBeDiv = k * 2
            for char in dictOfFreq:
                freq = dictOfFreq[char]
                if freq//toBeDiv >= 1 or not checkFor1:
                    checkFor1 = True
                else:
                    check = False
                    break
            return check

obj = Solution()
s = input()
k = int(input())
print(obj.canConstruct(s, k))