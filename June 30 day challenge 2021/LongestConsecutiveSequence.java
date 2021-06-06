import java.io.*;
import java.util.*;
class LongestConsecutiveSubsequence {
    class ListNode{
        ListNode prev, next;
        int val;
    }
    //better approach although both approaches have O(n) complexity
    public int longestConsecutive2(int[] nums){
        HashSet<Integer>set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num-1)){
                int cnt = 0, dup = num;
                while (set.contains(dup)){
                    dup++;
                    cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
    //approach that I came up with
    public int longestConsecutive(int[] nums) {
        Map<Integer, ListNode>map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num))
                continue;
            ListNode node = new ListNode();
            node.val = num;
            map.put(num, node);
            if(map.containsKey(num-1))
                node.prev = map.get(num-1);
            if(map.containsKey(num+1))
                node.next = map.get(num+1);
        }
        int ans = 0;
        for(ListNode node : map.values()){
            if(node.next != null)
                node.next.prev = node;
            if(node.prev != null)
                node.prev.next = node;
        }
        for(ListNode node : map.values()){
            if(node.prev == null){
                int cnt = 0;
                ListNode dup = node;
                while(dup != null){
                    cnt++;
                    dup = dup.next;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}