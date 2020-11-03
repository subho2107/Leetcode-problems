import java.io.*;
import java.util.*;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dup = head;
        int cnt = 0;
        while(dup != null){
            cnt++;
            dup = dup.next;
        }
        ListNode[]arr = new ListNode[cnt];
        dup = head;
        int i = 0;
        while(dup != null){
            arr[i] = dup;
            i++;
            dup = dup.next;
        }
         for(i = 0; i < cnt; i++){
             ListNode node = arr[i];
             int j;
             for(j = i-1; j >= 0 && node.val < arr[j].val; j--){
                arr[j+1] = arr[j];
             }
             if (j == i-1)
                 continue;
             arr[j+1] = node;
         }
        for (int j = 1; j < cnt; j++) {
            arr[j-1].next = arr[j];
        }
        arr[cnt-1].next = null;
        return arr[0];
    }
    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        ListNode ans = new InsertionSortList().insertionSortList(head);
    }
}
