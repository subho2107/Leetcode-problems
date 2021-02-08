import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class BinaryTreeRightSideView {
    List<Integer>list;
    Stack<TreeNode>stack;
    HashSet<TreeNode>visited;
    HashMap<TreeNode, Integer>levelOfNodes;
    int lastDeepestLevel;
    public void calcLevel(TreeNode node, int level){
        if (node == null)
            return;
        levelOfNodes.put(node, level);
        calcLevel(node.left, level+1);
        calcLevel(node.right, level+1);
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        int currLevel = levelOfNodes.get(root);
        if (currLevel > lastDeepestLevel) {
            list.add(root.val);
        }
        if (root.left != null && root.right != null && !visited.contains(root)) {
            stack.push(root);
        }
        else if (root.left == null && root.right == null && currLevel > lastDeepestLevel ) {
            lastDeepestLevel = currLevel;
        }
        visited.add(root);
        if(root.right != null && !visited.contains(root.right))
            dfs(root.right);
        else
            dfs(root.left);

    }
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        stack = new Stack<>();
        lastDeepestLevel = -1;
        visited = new HashSet<>();
        levelOfNodes = new HashMap<>();
        calcLevel(root, 0);
//        stack.push(root);
        stack.push(root);
//        dfs(root);
        while (!stack.isEmpty()){
            visited.add(stack.peek());
            if (root.left == null || root.right == null || visited.contains(stack.peek().right))
                dfs(stack.pop());
            else
                dfs(stack.peek());
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        System.out.println(new BinaryTreeRightSideView().rightSideView(root).toString());
    }
}
