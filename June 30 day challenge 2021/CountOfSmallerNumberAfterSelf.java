import java.io.*;
import java.util.*;

class CountOfSmallerNumberAfterSelf {
    static class FenwickTree{
        int [] bit;
        int n;
        FenwickTree(int size){
            bit = new int[size];
            n = size;
        }
        void update(int pos, int val){
            for(;pos < n; pos = pos|(pos+1))
                bit[pos] += val;
        }
        int query(int r){
            int cnt = 0;
            for(;r >= 0; r = (r&(r+1))-1)
                cnt += bit[r];
            return cnt;
        }

    }
    public List<Integer> countSmaller(int[] nums) {
        int MAX = 10001, n = nums.length;
        for(int i = 0; i < n; i++)//change range of values from [-10^4, 10^4] to [1, 2*10^4]
            nums[i] += MAX;
        FenwickTree tree = new FenwickTree(2 * MAX);
        Integer [] ans = new Integer[n];
        for(int i = n-1; i >= 0; i--){
            tree.update(nums[i], 1);
            ans[i] = tree.query(nums[i]-1);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(ans));
        return list;
    }
}