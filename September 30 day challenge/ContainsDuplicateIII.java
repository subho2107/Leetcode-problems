import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int pos = 0; pos < nums.length; pos++) {
            Long floor = set.floor((long) nums[pos] + t);
            Long ceil = set.ceiling((long) nums[pos] - t);
            if ((floor != null && floor >= nums[pos]) || (ceil != null && ceil <= nums[pos]))
                return true;
            set.add((long) nums[pos]);
            if (pos >= k)
                set.remove((long) nums[pos - k]);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
