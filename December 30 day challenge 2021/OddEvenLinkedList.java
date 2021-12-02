import java.io.*;
import java.util.*;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, temp = even;
        while(odd.next != null && odd.next.next != null || even.next != null && even.next.next != null){
            if(odd.next != null && odd.next.next != null){
                odd.next = odd.next.next;
                odd = odd.next;
            }
            if(even.next != null && even.next.next != null){
                even.next = even.next.next;
                even = even.next;
            }
        }
        odd.next = temp;
        even.next = null;
        return head;
    }
}
