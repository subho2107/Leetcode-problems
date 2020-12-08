import java.io.*;
import java.util.*;

public class MaximumDepthOfBinaryTreeDecChallenge {
    int max_depth;
    public void dfs(TreeNode node, int depth){
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            max_depth = Math.max(max_depth, depth);
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        max_depth = 0;
        dfs(root, 0);
        return max_depth+1;
    }
}
