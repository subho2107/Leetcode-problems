import java.io.*;
import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(), dup = head;
        int n = lists.length;
        while(true){
            ListNode smallest;
            int smallestVal = 10001, pos = -1;
            for(int i = 0; i < n; i++){
                if(lists[i] != null && lists[i].val < smallestVal){
                    smallestVal = lists[i].val;
                    smallest = lists[i];
                    pos = i;
                }
            }
            if(pos == -1)
                break;
            head.next = lists[pos];
            head = head.next;
            lists[pos] = lists[pos].next;
        }
        head.next = null;
        return dup.next;
    }
}
