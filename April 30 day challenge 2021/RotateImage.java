import java.io.*;
import java.util.*;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-i-1; j++){
                int diff = j-i;
                int [][] pos = {{i,j}, {i+diff, n-i-1}, {n-i-1, n-i-diff-1},{n-i-diff-1, i}};
                int [] vals = new int[4];
                for(int k = 0; k < 4; k++)
                    vals[(k+1)%4] = matrix[pos[k][0]][pos[k][1]];
                for(int k = 0; k < 4; k++)
                    matrix[pos[k][0]][pos[k][1]] = vals[k];
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int [][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new RotateImage().rotate(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
