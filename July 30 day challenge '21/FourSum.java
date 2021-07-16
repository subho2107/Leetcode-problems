import java.io.*;
import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    public List<List<Integer>> kSum(int [] nums, int start, int k, int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(start == nums.length  || nums[start]*k > target || nums[nums.length - 1]*k < target)
            return ans;
        if(k == 2)
            return twoSum(nums, start, target);
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1])
                continue;
            for(List<Integer> list : kSum(nums, i+1, k-1, target - nums[i])){
                ans.add(new ArrayList<>(Arrays.asList(nums[i])));
                ans.get(ans.size()-1).addAll(list);
            }
        }
        return ans;
    }
    public List<List<Integer>> twoSum(int [] nums, int start, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer>seen = new HashSet<>();
        for(int i = start; i < nums.length; i++){
            if(seen.contains(target - nums[i]) && (ans.isEmpty() || ans.get(ans.size() - 1).get(1) != nums[i]))
                ans.add(Arrays.asList(target - nums[i], nums[i]));
            seen.add(nums[i]);
        }
        return ans;
    }
}
