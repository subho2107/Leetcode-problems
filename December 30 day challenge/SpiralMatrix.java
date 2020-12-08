import java.io.*;
import java.util.*;

public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int row = 0, col = 0;
        int [][]matrix = new int[n][n];
        for(int i = 1; i <= n*n; i++){
            for(;col < n && matrix[row][col]==0; col++,i++)
                matrix[row][col] = i;
            col--;
            row++;
            for(;row < n && matrix[row][col]==0;row++, i++)
                matrix[row][col] = i;
            row--;col--;
            for(;col >=0 && matrix[row][col]==0; col--,i++)
                matrix[row][col] = i;
            col++;row--;
            for(;row >=0 && matrix[row][col]==0;row--, i++)
                matrix[row][col] = i;
            row++;col++;
            i--;
        }
        return matrix;
    }
    public static void main(String[] args) throws Exception {
        int [][]matrix = new SpiralMatrix().generateMatrix(3);
    }
}
