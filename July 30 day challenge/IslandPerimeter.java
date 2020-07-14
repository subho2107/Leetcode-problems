import java.io.*;
import java.util.*;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0, maxRow = grid.length, maxCol = grid[0].length;
        for(int rowPos = 0; rowPos < maxRow; rowPos++)
        {
            for(int colPos = 0; colPos < maxCol; colPos++)
            {
                if(grid[rowPos][colPos] == 1)
                {
                    if((rowPos + 1 < maxRow && grid[rowPos + 1][colPos] == 0)||(rowPos + 1 > maxRow - 1))
                        perimeter++;
                    if(rowPos - 1 < 0 || grid[rowPos - 1][colPos] == 0)
                        perimeter++;
                    if((colPos + 1 < maxCol && grid[rowPos][colPos + 1] == 0)||(colPos + 1 > maxCol - 1))
                        perimeter++;
                    if(colPos - 1 < 0 || grid[rowPos][colPos - 1] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int rowMax = Integer.parseInt(buffer.readLine());
        int colMax = Integer.parseInt(buffer.readLine());
        int [][] matrix = new int[rowMax][colMax];
        for (int rowPos = 0; rowPos < rowMax; rowPos++) {
            String[]inp = buffer.readLine().split( " ");
            for (int colPos = 0; colPos < colMax; colPos++) {
                matrix[rowPos][colPos] = Integer.parseInt(inp[colPos]);
            }
        }
        int perimeter = new IslandPerimeter().islandPerimeter(matrix);
        System.out.println(perimeter);
    }
}
