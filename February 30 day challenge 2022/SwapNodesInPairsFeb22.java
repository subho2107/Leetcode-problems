public class SwapNodesInPairsFeb22 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next, prev = null;
        while(head != null && head.next != null){
            ListNode nextNode = head.next, nextsNextNode = nextNode.next;
            if(prev != null)
                prev.next = nextNode;
            head.next = nextsNextNode;
            nextNode.next = head;
            prev = head;
            head = nextsNextNode;
        }
        return newHead;
    }
}
