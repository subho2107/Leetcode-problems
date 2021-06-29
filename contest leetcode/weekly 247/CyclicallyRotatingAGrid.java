import java.util.*;

public class CyclicallyRotatingAGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int orgK = k;
        for (int i = 0; i < Math.min(m/2, n/2); i++) {
            int x = i, y = i;
            ArrayList<int[]>list = new ArrayList<>();
            int col;
            for (col = i; col < n-i; col++) {
                list.add(new int[]{x,col, grid[x][col]});
            }
            col--;
            int row;
            for (row = i+1; row < m - i; row++) {
                list.add(new int[]{row, col, grid[row][col]});
            }
            col--;
            row--;
            for (;col >= i; col--)
                list.add(new int[]{row, col, grid[row][col]});
            row--;
            col++;
            for (;row > i; row--)
                list.add(new int[]{row, col, grid[row][col]});
            int [] dup = new int[list.size()];
            k = orgK%dup.length;
            for (int j = 0; j < dup.length; j++) {
                dup[(j-k < 0)?dup.length+j-k:j-k] = list.get(j)[2];
            }
            for (int j = 0; j < dup.length; j++) {
                grid[list.get(j)[0]][list.get(j)[1]] = dup[j];
            }
        }
        return grid;
    }
    public static void main(String[] args) throws Exception {
        int [][] matrix = {{40, 10}, {30, 20}};
        new CyclicallyRotatingAGrid().rotateGrid(matrix, 1);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
