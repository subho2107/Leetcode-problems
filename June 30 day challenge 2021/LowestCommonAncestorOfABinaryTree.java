import java.io.*;
import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    int a, b;
    TreeNode lca;
    public boolean dfs(TreeNode node){
        if(node == null)
            return false;
        boolean left = dfs(node.left), right = dfs(node.right);
        if((node.val == a || node.val == b) && (left || right))
        {
            lca = node;
            return true;
        }
        if(left && right){
            lca = node;
            return true;
        }
        if(node.val == a || node.val == b)
            return true;

        return left||right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        a = p.val;
        b = q.val;
        dfs(root);
        return lca;
    }
}
