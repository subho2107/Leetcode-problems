import java.io.*;
import java.util.*;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %=n;
        int cnt = 0;
        if (k == 0 || n == 1)
            return;
        for (int i = 0; cnt < n; i++) {
            int curr = i;
            int prev = nums[curr];
            do {
                int temp = nums[(curr+k)%n];
                nums[(curr+k)%n] = prev;
                prev = temp;
                curr +=k;
                curr%=n;
                cnt++;

            }while (curr!=i);
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
