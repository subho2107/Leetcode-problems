public class ReorderListDec {
    private ListNode getMiddleNode(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null)
            return prev;
        return slow;
    }
    private ListNode reverseList(ListNode head, ListNode prev){
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode middleNode = getMiddleNode(head), last = reverseList(middleNode.next, middleNode), dup = last;
        ListNode first = head, lastPrev = null, firstNext;
        while(last != first && lastPrev != first){
            if(lastPrev != null)
                lastPrev.next = first;
            firstNext = first.next;
            lastPrev = last;
            first.next = last;
            last = last.next;
            first = firstNext;
        }
        first.next = null;
    }
}
