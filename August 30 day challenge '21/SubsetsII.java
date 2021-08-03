import java.io.*;
import java.util.*;

public class SubsetsII {
    public void generateSet(int i, int[] nums, List<Integer> list, List<List<Integer>> ans,Set<String>seen, String curr){
        if(i == nums.length){
            if(seen.add(curr))
                ans.add(new ArrayList<>(list));
            return;
        }
        generateSet(i+1, nums, list, ans, seen, curr);
        curr += Integer.toString(nums[i]);
        list.add(nums[i]);
        generateSet(i+1, nums, list, ans, seen, curr);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<String>seen = new HashSet<>();
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        generateSet(0, nums, list, ans, seen , "");
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
