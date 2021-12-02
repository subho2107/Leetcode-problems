import java.io.*;
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int num : nums){
            int pos = Math.abs(num)-1;
            if(nums[pos] > 0)
                nums[pos] *= -1;
        }
        List<Integer>ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                ans.add(i+1);
        }

        return ans;
    }
}
