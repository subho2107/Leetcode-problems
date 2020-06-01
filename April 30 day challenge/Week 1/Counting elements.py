from typing import List
def countElements(arr: List[int]) -> int:
    elements = dict()
    for num in arr:
        if num not in elements:
            elements[num] = 1
    cnt = 0
    for num in arr:
        if num+1 in elements:
            cnt += 1

    return cnt


arr = list(map(int, input().rstrip().split()))
cnt = countElements(arr)
print(cnt)