import java.io.*;
import java.util.*;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node>map = new HashMap<>();
        Node dup = head;
        while(dup != null){
            map.put(dup, new Node(dup.val));
            dup = dup.next;
        }
        for(Node node : map.keySet()){
            Node temp = map.get(node);
            temp.next = map.get(node.next);
            temp.random = map.get(node.random);
        }
        return map.get(head);
    }
}
