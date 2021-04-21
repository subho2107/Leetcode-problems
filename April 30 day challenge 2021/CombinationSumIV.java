import java.util.*;

public class CombinationSumIV {
    int cnt;
    ArrayList<Integer> list;
    int[] dp;

    public void backtrack(int[] nums, int left) {
        if (dp[left] != -1) {
            cnt += dp[left];
            return;
        }
        if (left == 0) {
            cnt++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > left)
                break;
            list.add(nums[i]);
            int prev = cnt;
            backtrack(nums, left - nums[i]);
            dp[left - nums[i]] = cnt - prev;
            list.remove(list.size() - 1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        cnt = 0;
        dp = new int[1001];
        Arrays.fill(dp, -1);
        backtrack(nums, target);
        return cnt;
    }
}
