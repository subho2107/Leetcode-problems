from typing import List
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        orgColor = image[sr][sc]
        if orgColor == newColor:
            return image
        rowMax = len(image)
        colMax = len(image[0])
        def dfs(rowPos, colPos, image):
            if rowPos < 0 or colPos < 0 or rowPos > rowMax-1 or colPos > colMax-1 or image[rowPos][colPos]!=orgColor:
                return
            image[rowPos][colPos] = newColor
            dfs(rowPos, colPos-1, image)
            dfs(rowPos, colPos+1, image)
            dfs(rowPos+1, colPos, image)
            dfs(rowPos-1, colPos, image)
        dfs(sr, sc, image)
        return image
obj = Solution()
arr = [[0,0,0],[0,1,1]]
print(obj.floodFill(arr, 1, 1, 1))