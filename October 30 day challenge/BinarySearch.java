import java.io.*;
import java.util.*;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int high = nums.length - 1, low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;

    }
}
