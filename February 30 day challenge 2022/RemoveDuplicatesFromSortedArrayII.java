import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while(j < n){
            int org = nums[j];
            for(int k = 0; j < n && nums[j] == org; k++, j++){
                if(k < 2)
                    nums[i++] = nums[j];
            }
        }
        return i;
    }
}
