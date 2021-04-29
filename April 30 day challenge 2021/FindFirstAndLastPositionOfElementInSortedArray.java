import java.io.*;
import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1, n = nums.length;
        if(n == 0)return new int[]{-1, -1};
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else {
                if (nums[mid] == target)
                    start = mid;
                high = mid - 1;
            }
        }
        low = 0;
        high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] <= target) {
                low = mid + 1;
                if (nums[mid] == target)
                    end = mid;
            }
            else
                high = mid-1;
        }
        return new int[]{start, end};
    }
    public static void main(String[] args) throws Exception {
        int [] nums = {1,2,3};
        int [] ans = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 2);
        System.out.println(Arrays.toString(ans));
    }
}
