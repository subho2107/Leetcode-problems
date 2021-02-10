import java.io.*;
import java.util.*;

public class ConvertBSTToGreaterTree {
    int sum;
    public void dfs(TreeNode node){
        if(node == null)
            return;
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }
}
