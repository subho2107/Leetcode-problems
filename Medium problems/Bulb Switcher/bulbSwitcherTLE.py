from math import sqrt


class Solution:
    def cntOfFactors(self, num):
        if num == 1:
            return 1
        else:
            cnt = 2
            for fact in range(2, int(sqrt(num)) + 1):
                if num % fact == 0:
                    if fact != num / fact:
                        cnt += 2
                    else:
                        cnt += 1
            return cnt

    def bulbSwitch(self, n: int) -> int:
        noOfToggles = []
        for switch in range(1, n + 1):
            getCnt = Solution().cntOfFactors(switch)
            noOfToggles.append(getCnt)
        #print(noOfToggles)
        cntOfON = 0
        for toggle in noOfToggles:
            if toggle % 2 != 0:
                cntOfON += 1
        return cntOfON

obj = Solution()
print("Enter the value of n")
print(obj.bulbSwitch(int(input())))