import java.io.*;
import java.util.*;

public class CheckArrayFormationThroughConcatenation {
    public boolean isPresent(int start, int end, int [] arr, int [][] pieces){
        for(int [] piece : pieces){
            if(piece.length != end-start+1)
                continue;
            boolean check = true;
            for(int i = 0; i < piece.length; i++){
                if(arr[i+start] != piece[i]){
                    check = false;
                    break;
                }
            }
            if(check)
                return true;
        }
        return false;
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int j;
            for(j = i; j < n; j++){
                if(isPresent(i, j, arr, pieces))
                    break;
                else if(j == n-1)
                    return false;
            }
            i = j;
        }
        return true;
    }
}
