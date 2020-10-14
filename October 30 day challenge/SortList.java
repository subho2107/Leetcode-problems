import java.io.*;
import java.util.*;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMidOfList(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode listA, ListNode listB) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (listA != null && listB != null) {
            if (listA.val < listB.val) {
                curr.next = listA;
                listA = listA.next;
            } else {
                curr.next = listB;
                listB = listB.next;
            }
            curr = curr.next;
        }
        curr.next = (listA == null) ? listB : listA;
        return dummy.next;
    }

    public ListNode getMidOfList(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;

    }
}
