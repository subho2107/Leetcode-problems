from math import sqrt

factorsCnt = []
def cntOfFactors(num):
    global factorsCnt
    print(factorsCnt)
    if num == 1:
        return 1
    else:
        cntPrev = 0
        start = 2
        for factCnt in reversed(factorsCnt):
            fact = factCnt[0]
            if num % fact == 0:
                cntPrev = factCnt[1]
                start = factorsCnt[len(factorsCnt)-1][0] + 1
                break

        if cntPrev == 0:
            cnt = 2
        else:
            cnt = 1
            cnt += cntPrev
        for fact in range(start, int(sqrt(num)) + 1):
            if num % fact == 0:
                if fact != num / fact:
                    cnt += 2
                else:
                    cnt += 1
        factorsCnt.append([num, cnt])
        return cnt

class Solution:


    def bulbSwitch(self, n: int) -> int:
        noOfToggles = []
        for switch in range(1, n+1):
            getCnt = cntOfFactors(switch)
            noOfToggles.append(getCnt)
        print(noOfToggles)
        #print(noOfToggles)
        cntOfON = 0
        for toggle in noOfToggles:
            if toggle % 2 != 0:
                cntOfON += 1
        return cntOfON

obj = Solution()
print("Enter the value of n")
print(obj.bulbSwitch(int(input())))