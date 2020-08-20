import java.io.*;
import java.util.*;

//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null)return;
        ArrayList<ListNode>vals = new ArrayList<>();
        while(head!=null){
            vals.add(head);
            head = head.next;
        }
        int n = vals.size();
        for(int pos = 0; pos < n/2; pos++){
            vals.get(pos).next = vals.get(n-pos-1);
            vals.get(n-pos-1).next = vals.get(pos+1);
            System.out.println(vals.get(pos).val+" "+ vals.get(pos).next.val+" "+vals.get(pos).next.next.val);
        }
        vals.get(n/2).next = null;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(head);
    }
}
