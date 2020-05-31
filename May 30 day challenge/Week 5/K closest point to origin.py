from typing import List
import math
def sortOneBasedOnOther(arr1, arr2):
    return [x for x,_ in sorted(zip(arr1, arr2), key=lambda x: x[1])]
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        distList = []
        for point in points:
            x = point[0]
            y = point[1]
            distList.append(math.sqrt(x**2+y**2))
        sortedDists = sortOneBasedOnOther(points, distList)
        return sortedDists[:K]