import java.io.*;
import java.util.*;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        Deque<Integer>deque = new ArrayDeque<>();
        deque.add(0);
        for(int i = 1; i < nums.length; i++){
            while(!deque.isEmpty() && deque.peekFirst() < i- k)
                deque.pollFirst();

            nums[i] += deque.isEmpty()?0:nums[deque.peekFirst()];
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.add(i);
        }
        return nums[nums.length - 1];
    }
}
