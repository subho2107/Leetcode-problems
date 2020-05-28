MAX = 1000001

factor = [0]*(MAX + 1)

def generatePrimeFactors():
    factor[1] = 1
    for i in range(2,MAX):
        factor[i] = i


    for i in range(4,MAX,2):
        factor[i] = 2

    i = 3
    while i*i < MAX:
        if factor[i] == i:
            j = i*i
            while j < MAX:
                if (factor[j] == j):
                    factor[j] = i
                j += i
        i+=1


def countFactors(n):
    if n == 1:
        return 1
    res = 1
    dup = factor[n]
    count = 1

    j = int(n / factor[n])

    while j > 1:
        if factor[j] == dup:
            count += 1
        else:
            dup = factor[j]
            res = res * (count + 1)
            count = 1

        j = int(j / factor[j])

    res = res * (count + 1)

    return res

class Solution:
    def bulbSwitch(self, n: int) -> int:
        noOfToggles = []

        generatePrimeFactors()
        for switch in range(1, n + 1):
            getCnt = countFactors(switch)
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