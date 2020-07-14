import java.io.*;
import java.util.*;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        int largestNum = nums.length;
        List<List<Integer>>res = new ArrayList<>();
        for (int pos = 1<<largestNum; pos < 1<<(largestNum+1); pos++) {
            String bit = Integer.toBinaryString(pos).substring(1);
            ArrayList<Integer>temp = new ArrayList<>();
            for (int arrPos = 0; arrPos < largestNum; arrPos++) {
                if (bit.charAt(arrPos) == '1')temp.add(nums[arrPos]);
            }
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] a = {1, 2};
        new Subset().subsets(a);
        System.out.println(sb);
    }
}
