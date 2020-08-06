import java.io.*;
import java.util.*;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] arr) {
        int pos = 0, n = arr.length;
        while(pos< n)
        {
            while(arr[pos]!= arr[arr[pos]-1]){
                arr[pos] = arr[arr[pos]-1]^arr[pos]^(arr[arr[pos]-1]=arr[pos]);
            }
            pos++;
        }
        ArrayList<Integer> missingNumbers = new ArrayList<>();
        for(pos = 0; pos < n; pos++){
            if(arr[pos]!=(pos+1))
                missingNumbers.add(arr[pos]);
        }
        return missingNumbers;
    }
}
