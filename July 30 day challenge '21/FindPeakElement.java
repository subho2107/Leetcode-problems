import java.io.*;
import java.util.*;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1])
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }
}
