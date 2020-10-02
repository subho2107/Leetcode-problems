import java.io.*;
import java.util.*;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = nums[0];
        int n = nums.length;
        int j = 0, cnt = 0;
        if(nums[0]<k)
            cnt++;
        for(int i = 1; i < n; i++){
            product*=nums[i];
            while(product>=k && j<=i){
                product/=nums[j];
                j++;
            }
            if(j<i)
                cnt+=i-j+1;
            else if(nums[i]<k)
                cnt++;
        }
        return cnt;
    }
}
