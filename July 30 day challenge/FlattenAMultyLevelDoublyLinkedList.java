import java.io.*;
import java.util.*;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
public class FlattenAMultyLevelDoublyLinkedList {
    public Node dfs(Node node)
    {
        if(node.next==null && node.child==null)
            return node;
        while(node.child==null && node.next!=null)
        {
            node = node.next;
        }
        if(node != null && node.next==null && node.child==null)
            return node;
        if(node.child == null && node.next!=null)
            return dfs(node.next);
        else
        {
            Node lastChild = dfs(node.child);
            if(node.next != null)
            {
                lastChild.next = node.next;
                node.next.prev = lastChild;
            }
            node.next = node.child;
            node.child.prev = node;
            node.child = null;
            return dfs(lastChild.next);
        }
    }
    public Node flatten(Node head) {
        if(head==null)return head;
        Node dup = head;
        dfs(head);
        return dup;
    }
}
