import java.io.*;
import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null)
            return node;
        if((p.val > node.val && q.val < node.val)||(p.val < node.val && q.val > node.val)||(node.val == p.val || node.val == q.val))
            return node;
        TreeNode left = dfs(node.left, p, q), right = dfs(node.right, p, q);
        if(left != null || right != null)
            return left == null?right:left;
        return null;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
}
