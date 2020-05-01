arr = [[1,2,4],[1,2,4],[8,9,0]]
arr = list(map(list,(set(map(tuple, arr)))))
print(arr)