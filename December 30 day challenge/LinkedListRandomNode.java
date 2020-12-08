import java.io.*;
import java.util.*;

public class LinkedListRandomNode {
    ArrayList<Integer>nums;
    public LinkedListRandomNode(ListNode head) {
        nums = new ArrayList<>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int pos = (int)(Math.random()*nums.size());
        return nums.get(pos);
    }
}
