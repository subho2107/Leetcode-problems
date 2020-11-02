import java.io.*;
import java.util.*;

public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        String binary = "";
        while(head != null){
            binary += Integer.toString(head.val);
            head = head.next;
        }
        int decimal = 0, n = binary.length();
        for(int i = 0; i < n; i++){
            decimal += binary.charAt(i) == '1'?(1<<(n-i-1)):0;
        }
        return decimal;
    }
}
