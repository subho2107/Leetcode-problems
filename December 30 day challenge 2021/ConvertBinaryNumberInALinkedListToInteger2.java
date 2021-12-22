import java.io.*;

public class ConvertBinaryNumberInALinkedListToInteger2 {
    private int getLinkedListLength(ListNode head){
        if(head == null)
            return 0;
        int len = 1;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            len++;
        }
        if(fast == null)
        {
            len--;
            len*=2;
        }
        else{
            len *= 2;
            len--;
        }
        return len;
    }
    public int getDecimalValue(ListNode head) {
        int len = getLinkedListLength(head), num = 0, pow = (int)Math.pow(2, len-1);
        while(head != null){
            num += head.val*pow;
            pow /= 2;
            head = head.next;
        }
        return num;
    }
    public int getDecimalValue2(ListNode head) {
        int ans = head.val;
        while (head.next != null){
            ans = ans << 1 | head.next.val;
            head = head.next;
        }
        return ans;
    }
}
