import java.io.*;
import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        if(n == 0)
            return list;
        int start = nums[0], end = 0;
        for(int i = 1; i < n; i++){
            if(nums[i]-nums[i-1] == 1)
                continue;
            else{
                end = nums[i-1];
                if(start == end)
                    list.add(Integer.toString(start));
                else
                    list.add(start+"->"+end);
                start = nums[i];
            }
        }
        end = nums[n-1];
        if(start == end)
            list.add(Integer.toString(start));
        else
            list.add(start+"->"+end);
        return list;
    }
}
