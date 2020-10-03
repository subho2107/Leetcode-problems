import java.io.*;
import java.util.*;

public class CombinationSum {
    public void recursion(List<List<Integer>> ans, List<Integer> tempAns, int[] candidates, int target, int pos) {
        if (target == 0) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        else if (target < 0)
            return;

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempAns.add(candidates[i]);
                this.recursion(ans, tempAns, candidates, target - candidates[i], i);
                tempAns.remove(tempAns.size() - 1);
            } else
                break;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempAns = new ArrayList<>();
        this.recursion(ans, tempAns, candidates, target, 0);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(arr, 7).toString());
    }
}
