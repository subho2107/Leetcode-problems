import java.io.*;
import java.util.*;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode a = null, b = null, prev = null, dup = head;
        while(head != null && cnt <= right){
            ListNode next = head.next;
            if(cnt == left - 1)
                a  = head;
            if(cnt > left && cnt <= right){
                head.next = prev;
            }
            prev = head;
            head = next;
            cnt++;
        }
        b = head;
        if(a == null && b == null){
            dup.next = null;
            return prev;
        }
        else if(a == null){
            dup.next = b;
            return prev;
        }
        else{
            a.next.next = b;
            a.next = prev;
        }
        return dup;
    }
}
