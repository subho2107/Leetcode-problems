import java.io.*;
import java.util.*;

public class Subsets {
    static List<List<Integer>>list;
    private void getSubsets(int [] nums, int pos, List<Integer>curr){
        if(pos == nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        getSubsets(nums, pos+1, curr);
        curr.add(nums[pos]);
        getSubsets(nums, pos+1, curr);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        List<Integer>curr = new ArrayList<>();
        getSubsets(nums, 0, curr);
        return list;
    }
}
