import java.io.*;
import java.util.*;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        ArrayList<Integer> difference = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++)
            difference.add(nums[i + 1] - nums[i]);
        int cnt = 0;
        int initialState = -1;
        for (int i = 0; i < n - 1; i++) {
            if (difference.get(i) * initialState < 0) {
                cnt++;
                initialState *= -1;
            }
        }
        int ans = cnt;
        cnt = 0;
        initialState = 1;
        for (int i = 0; i < n - 1; i++) {
            if (difference.get(i) * initialState < 0) {
                cnt++;
                initialState *= -1;
            }
        }
        ans = Math.max(ans, cnt);
        return ans+1;
    }

    public static void main(String[] args) {
        int [] arr = {1,7,4,9,2,5};
        new WiggleSubsequence().wiggleMaxLength(arr);
    }
}
