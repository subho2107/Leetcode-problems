import java.io.*;
import java.util.*;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int prevPos = -1, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                if(prevPos != -1 && i-prevPos-1 < k)
                    return false;
                prevPos = i;
            }
        }
        return true;
    }
}
