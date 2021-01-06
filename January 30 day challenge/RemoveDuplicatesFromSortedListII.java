import java.io.*;
import java.util.*;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null && head.next != null && head.next.val == head.val)
        {
            int temp = head.val;
            while (head != null && head.val == temp)
                head = head.next;
            if(head != null && head.next != null && head.val == head.next.val)
                head = deleteDuplicates(head);
        }
        if (head == null)
            return null;
        ListNode ans = head, prev = head;
        head = head.next;
        while(head != null){
            ListNode dup = head;
            while(dup != null && dup.val == head.val){
                dup = dup.next;
            }
            if (dup != head.next)
            {
                prev.next = dup;
                head = dup;
            }
            else {
                prev = head;
                head = head.next;
            }
        }
        return ans;
    }
}
