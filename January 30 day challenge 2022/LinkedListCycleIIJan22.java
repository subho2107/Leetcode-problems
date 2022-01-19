import java.io.*;
import java.util.*;

public class LinkedListCycleIIJan22 {
    public ListNode detectCycle(ListNode head) {//brute force
        while(head != null){
            ListNode slow = head, fast = head;
            boolean cycleFound = false;
            while(slow != null && fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    cycleFound = true;
                    break;
                }
            }
            if(!cycleFound)
                return null;
            if(slow == head)
                return head;
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) {//Time complexity: O(n), Space complexity: O(n)
        Set<ListNode>set = new HashSet<>();
        while(head != null){
            if(!set.add(head))
                return head;
            head = head.next;
        }
        return null;
    }
    public ListNode detectCycle3(ListNode head) {//Time complexity: O(n), Space complexity: O(1)
        int [][] arr = {{1, 2}};
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        ListNode slow = head, fast = head, entry = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(entry != slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
