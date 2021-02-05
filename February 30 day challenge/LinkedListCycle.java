import java.io.*;
import java.util.*;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while(hare != null && tortoise != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare)
                return true;
        }
        return false;
    }
}
