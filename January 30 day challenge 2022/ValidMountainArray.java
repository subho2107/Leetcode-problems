import java.io.*;
import java.util.*;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0, mid;
        while(i+1 < n && arr[i] <= arr[i+1]){
            if(arr[i] == arr[i+1])
                return false;
            i++;
        }
        mid = i+1;
        while(i < n-1){
            if(arr[i] <= arr[i+1])
                return false;
            i++;
        }
        return mid < n && mid > 1;
    }
}
