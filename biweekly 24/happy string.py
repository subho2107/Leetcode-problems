class Solution:
    def generate(self, arr, n):
        if len(arr[0]) == n:
            return arr
        arr2 = []
        for ch in arr:
            if ch[-1] == 'a':
                arr2.append(ch+'b')
                arr2.append(ch+'c')
            elif ch[-1] == 'b':
                arr2.append(ch+'a')
                arr2.append(ch+'c')
            else:
                arr2.append(ch+'a')
                arr2.append(ch+'b')
        return self.generate(arr2, n)
    def getHappyString(self, n: int, k: int) -> str:
        a = ['a']
        b = ['b']
        c = ['c']
        a = self.generate(a, n)
        b = self.generate(b, n)
        c = self.generate(c, n)
        if k <= len(a):
            return a[k-1]
        elif k <= len(a)+len(b):
            k -= len(a)
            return b[k-1]
        elif k <= len(a)+len(b)+len(c):
            k -= len(a)+len(b)
            return c[k-1]
        else:
            return ""
        
t = int(input())
for _ in range(t):
    n, k = map(int, input().rstrip().split())
    print(Solution().getHappyString(n, k))
