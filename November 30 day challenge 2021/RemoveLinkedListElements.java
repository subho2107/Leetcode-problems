import java.io.*;
import java.util.*;

class RemoveLinkedListElementsNov{
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)
            head = head.next;
        ListNode dup = head;
        if(dup == null)
            return dup;
        while(dup != null && dup.next != null){
            while(dup.next != null && dup.next.val == val)
                dup.next = dup.next.next;
            dup = dup.next;
        }
        return head;
    }
}
