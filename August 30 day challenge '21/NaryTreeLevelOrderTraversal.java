import java.io.*;
import java.util.*;

public class NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> curr = new ArrayList<>();
        while (queue.size() != 0) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                Node node = queue.poll();
                curr.add(node.val);
                for (Node neighbour : node.children)
                    queue.add(neighbour);
            }
            ans.add(new ArrayList<>(curr));
            curr.clear();
        }
        return ans;
    }
}
