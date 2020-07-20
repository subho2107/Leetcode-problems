import java.io.*;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode dup = head;
        while(dup!=null && dup.next != null){
            while(dup.next != null && dup.next.val == val)
            {
                dup.next = dup.next.next;
            }
            dup = dup.next;
        }
        if(head.val == val)
            return head.next;
        return head;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
