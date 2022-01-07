public class LinkedListRandomNodeJan22 {
    private ListNode head;
    public LinkedListRandomNodeJan22(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int scope = 1, ans = 0;
        ListNode curr = head;
        while(curr != null){
            if(Math.random() < 1.0/scope)
                ans = curr.val;
            curr = curr.next;
            scope++;
        }
        return ans;
    }
}
