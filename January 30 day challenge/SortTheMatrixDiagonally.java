import java.io.*;
import java.util.*;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int row = 0, col = i;
            list.clear();
            while(row < n && col < m){
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = 0; col = i;
            int j = 0;
            while(row < n && col < m){
                mat[row][col] = list.get(j);
                row++;
                col++;
                j++;
            }
        }
        for(int i = 1; i < n; i++){
            int row = i, col = 0;
            list.clear();
            while(row < n && col < m){
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = i; col = 0;
            int j = 0;
            while(row < n && col < m){
                mat[row][col] = list.get(j);
                row++;
                col++;
                j++;
            }
        }
        return mat;
    }
}
