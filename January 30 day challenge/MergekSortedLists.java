import java.io.*;
import java.util.*;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        while(true){
            int notNullCnt = 0, minNodePos = -1, secMinPos = -1, n = lists.length;
            for(int i = 0; i < n; i++){
                ListNode node = lists[i];
                if(node != null)
                {
                    notNullCnt++;
                    if(minNodePos == -1 || node.val < lists[minNodePos].val){
                        minNodePos = i;
                    }
                }
            }
            if(ans == null && minNodePos != -1)
                ans = lists[minNodePos];
            else if(ans == null)
                return ans;
            if(notNullCnt <= 1)
                break;
            for(int i = 0; i < n; i++){
                ListNode node = lists[i];
                if(node != null){
                    if(i != minNodePos && (secMinPos == -1 || node.val < lists[secMinPos].val)){
                        secMinPos = i;
                    }
                }
            }
            ListNode prev = null;
            while(lists[minNodePos] != null && lists[minNodePos].val <= lists[secMinPos].val){
                prev = lists[minNodePos];
                lists[minNodePos] = lists[minNodePos].next;
            }
            prev.next = lists[secMinPos];
        }
        return ans;
    }
}
