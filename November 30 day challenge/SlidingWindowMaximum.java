import java.io.*;
import java.util.*;
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer>arraylist = new ArrayList<>();
        Deque<Integer>items = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (items.size() > 0 && items.getFirst()< i-k)
                items.removeFirst();
            while (items.size() > 0 && nums[i] >= nums[items.getLast()])
                items.removeLast();
            items.addLast(nums[i]);
            if (i-(k-1)>=0)
                arraylist.add(nums[items.getFirst()]);
        }
        return arraylist.stream().mapToInt(o->o).toArray();
    }
}
