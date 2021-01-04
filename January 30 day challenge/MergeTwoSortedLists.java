import java.io.*;
import java.util.*;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode prev = null;
        ListNode ans = l1;
        if(l2.val < l1.val)
            ans = l2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                while(l1 != null && l1.val <= l2.val){
                    prev = l1;
                    l1 = l1.next;
                }
                prev.next = l2;
            }
            else{
                while(l2 != null && l2.val < l1.val){
                    prev = l2;
                    l2 = l2.next;
                }
                prev.next = l1;
            }
        }
        return ans;
    }
}
