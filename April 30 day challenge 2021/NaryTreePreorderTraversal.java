import java.io.*;
import java.util.*;

public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
//    List<Integer> list;

//    public void dfs(Node root) {
//        list.add(root.val);
//        for (Node neighbour : root.children)
//            dfs(neighbour);
//    }
//
//    public List<Integer> preorder(Node root) {
//        list = new ArrayList<>();
//        if (root == null)
//            return list;
//        dfs(root);
//        return list;
//    }
    public List<Integer> preorder(Node root) {
        List<Integer>list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<Node>stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            list.add(curr.val);
            Stack<Node>temp = new Stack<>();
            for(Node neighbour : curr.children)
                temp.add(neighbour);
            while(!temp.isEmpty())
                stack.add(temp.pop());
        }
        return list;
    }
}
