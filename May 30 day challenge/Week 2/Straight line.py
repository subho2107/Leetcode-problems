from typing import List
class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 2:
            return True
        elif coordinates[0][0]-coordinates[1][0] == 0:
            for (x, y) in coordinates[2:]:
                if x != coordinates[0][0]:
                    return False
            return True
        elif coordinates[0][1]-coordinates[1][1] == 0:
            for (x, y) in coordinates[2:]:
                if y != coordinates[0][0]:
                    return False
            return True
        else:
            slope = (coordinates[0][1]-coordinates[1][1])//(coordinates[0][0]-coordinates[1][0])
            y1 = coordinates[0][1]
            x1 = coordinates[0][0]
            for (x,y) in coordinates[2:]:
                if (y-y1) != slope*(x-x1):
                    return False
            return True