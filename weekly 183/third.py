class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        s = ""
        most = ['a',a]
        mid = ['b',b]
        low = ['c',c]
        if a > b and a > c:
            if c > b:
                mid = ['c', c]
        elif b > c and b > a:
            most = ['b',b]
            mid = ['c',c]
            low = ['a',a]
            if a > c:
                mid =['a',a]
                low = ['c',c]
        else:
            most = ['c',c]
            mid = ['b',b]
            low =['a',a]
            if b > a:
                mid = ['b',b]
                low = ['a',a]
        cnt = 1
        check = True
        while True:
            if cnt == 3:
                cnt = 0
            if most[1] == 0 and mid[1] == 0 and low[1] == 0:
                break
            if most[1] == 0 and mid[1] == 0 and low[1] != 0:
                if low[1] <= 2 and s[len(s)-1]!=low[0] and s[len(s)-2] != low[0]:
                    s += low[0]*low[1]
                else:
                    check = False
                    break
            elif most[1] == 0 and mid[1] != 0 and low[1] == 0:
                if mid[1] <= 2 and s[len(s)-1]!=mid[0] and s[len(s)-2] != mid[0]:
                    s += mid[0]*mid[1]
                else:
                    check = False
                    break
            elif most[1] != 0 and mid[1] == 0 and low[1] == 0:
                if most[1] <= 2 and s[len(s)-1]!=most[0] and s[len(s)-2] != most[0]:
                    s += most[0]*most[1]
                else:
                    check = False
                    break
            if cnt == 1:
                rep = most[1]
                if rep == 0:
                    cnt += 1
                    continue
                elif rep == 1:
                    s += most[0]*1
                    most[1]-=1
                else:
                    s += most[0]*2
                    most[1] -= 2
            elif cnt == 2:
                rep = mid[1]
                if rep == 0:
                    cnt += 1
                    continue
                if rep > 0:
                    if rep == 1:
                        if most[1] > 2 and low[1] == 0:
                            cnt += 1
                            continue
                        s += mid[0]*1
                        mid[1]-=1
                    else:
                        s += mid[0]*2
                        mid[1] -= 2
            else:
                rep = low[1]
                if rep == 0:
                    cnt += 1
                    continue
                if rep > 0:
                    if rep == 1:
                        if mid[1] > 2 or most[1] > 2:
                            cnt += 1
                            continue 
                        s += low[0]*1
                        low[1]-=1
                    else:
                        s += low[0]*2
                        low[1] -= 2

            
            cnt+= 1
        print(s)
        if check:
            return s
        else:
            return ""

arr= list(map(int, input().rstrip().split()))
print(Solution().longestDiverseString(arr[0], arr[1], arr[2]))
