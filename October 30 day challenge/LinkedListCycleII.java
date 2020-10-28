import java.io.*;
import java.util.*;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        HashSet<ListNode>set = new HashSet<>();
        ListNode dup = head, cycleAt = null;
        while(dup!=null){
            if(!set.add(dup)){
                cycleAt = dup;
                break;
            }
            dup = dup.next;
        }
        while(head.next != null){
            if(head == cycleAt)
                return head;
            head = head.next;
        }
        return null;
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
