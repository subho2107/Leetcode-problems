import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack.add(l1.val);
            l1 = l1.next;
        }
        while (!stack.isEmpty())
            a.append(stack.pop());
        while (l2 != null) {
            stack.add(l2.val);
            l2 = l2.next;
        }
        while (!stack.isEmpty())
           b.append(stack.pop());
        BigInteger num1 = new BigInteger(a.toString()), num2 = new BigInteger(b.toString());
        ListNode ans = new ListNode();
        BigInteger sum = num1.add(num2);
        ListNode dup = ans;
        int n = sum.toString().length();
        for (int i = 0; i < n; i++) {
            ans.val = sum.remainder(new BigInteger("10")).intValue();
            sum = sum.divide(new BigInteger("10"));
            if (i != n - 1) {
                ans.next = new ListNode();
                ans = ans.next;

            }
        }

        return dup;
    }
}
