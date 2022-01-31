import java.io.*;

public class RotateArrayJan22 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
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
}
