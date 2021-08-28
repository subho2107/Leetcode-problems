import java.io.*;
import java.util.*;

public class TwoSumIVInputIsABST {
    class BSTIterator{
        Stack<TreeNode>stack;
        boolean reversed;
        BSTIterator(TreeNode root, boolean rev){
            stack = new Stack<>();
            reversed = rev;
            push(root);
        }
        void push(TreeNode node){
            while(node != null){
                stack.push(node);
                node = reversed?node.right:node.left;
            }
        }
        int next(){
            TreeNode top = stack.pop();
            push(reversed?top.left:top.right);
            return top.val;
        }
    }
    //approach 2 by o(h) memory
    public boolean findTarget2(TreeNode root, int k) {
        BSTIterator leftItr = new BSTIterator(root, false);
        BSTIterator rightItr = new BSTIterator(root, true);
        int left = leftItr.next(), right = rightItr.next();
        while (left < right) {
            if (left + right == k)
                return true;
            else if (left + right < k)
                left = leftItr.next();
            else
                right = rightItr.next();
        }
        return false;
    }
    public boolean dfs(TreeNode node, int k, Set<Integer>prev)
    {
        if(node == null)
            return false;
        boolean found = dfs(node.left, k, prev) || dfs(node.right, k, prev) || prev.contains(k - node.val);
        prev.add(node.val);
        return found;
    }
    //approach 1 by o(n) memory
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }
}
