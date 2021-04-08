import java.io.*;
import java.util.*;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head, fast = head, prev = null, temp = null;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
            slow = fast == null ? slow : slow.next;
            while(prev != null){
                if(prev.val != slow.val)
                    return false;
                prev = prev.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
