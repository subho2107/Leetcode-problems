import java.io.*;
import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == num1)
                cnt1++;
            else if (num == num2)
                cnt2++;
            else if (cnt1 == 0) {
                num1 = num;
                cnt1++;
            }
            else if (cnt2 == 0) {
                num2 = num;
                cnt2++;
            }
            else{
                cnt1--;cnt2--;
            }
        }
        int cnt = nums.length/3;
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == num1)
                cnt1++;
            else if (num == num2)
                cnt2++;
        }
        List<Integer>list = new ArrayList<>();
        if (cnt1 > cnt)
            list.add(num1);
        if (cnt2 > cnt)
            list.add(num2);
        return list;
    }
}
