import java.io.*;
import java.util.*;

class NumArray {
    int[] arr;

    public NumArray(int[] nums) {
        arr = nums.clone();
        for (int i = 1; i < nums.length; i++)
            arr[i] += arr[i - 1];
    }

    public int sumRange(int left, int right) {
        int sum = arr[right];
        sum -= left == 0 ? 0 : arr[left - 1];
        return sum;
    }
}
