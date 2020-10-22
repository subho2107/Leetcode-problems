import java.io.*;
import java.util.*;

public class MinimumDepthOfBinaryTree {
    int minDepth;
    public void util(TreeNode node, int cnt){
        if(node == null) return;
        cnt++;
        if(node.left == null && node.right == null)
            minDepth = Math.min(cnt, minDepth);
        if(node.left != null)
            util(node.left, cnt);
        if(node.right != null)
            util(node.right, cnt);
    }
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        minDepth = Integer.MAX_VALUE;
        util(root, 0);
        return minDepth;
    }
}
