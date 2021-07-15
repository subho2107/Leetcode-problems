import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
    public int getCeilPosition(int [] arr, int num, int n){
        int low = 0, high = n-1;
        while(low < high){
            int mid = (low + high)/2;
            if(num <= arr[mid])
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] piles = new int[n];
        int len = 1;
        piles[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] < piles[0])
                piles[0] = nums[i];
            else if(nums[i] > piles[len-1])
                piles[len++] = nums[i];
            else
                piles[getCeilPosition(piles, nums[i], len)] = nums[i];
        }
        return len;
    }

    public static void main(String[] args)throws Exception{
        int [] arr = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(arr));
    }
}
