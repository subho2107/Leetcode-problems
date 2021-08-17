import java.io.*;
import java.util.*;

public class CountGoodNodesInBinaryTree {
    public int dfs(TreeNode node, int maxVal){
        if(node == null)
            return 0;
        int cnt = 0;
        if(node.val >= maxVal)
            cnt++;
        maxVal = Math.max(maxVal, node.val);
        cnt += dfs(node.left, maxVal)+dfs(node.right, maxVal);
        return cnt;
    }
    public int goodNodes(TreeNode root){
        if(root == null)
            return 0;
        return dfs(root, Integer.MIN_VALUE);
    }
}
