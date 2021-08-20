import java.io.*;
import java.util.*;

public class MaximumProductOfSplittedBinaryTree {
    Map<TreeNode, Long>subtreeSize;
    public void calcSize(TreeNode node){
        if(node == null)
            return;
        long currSize = node.val;
        calcSize(node.left);
        calcSize(node.right);
        currSize += subtreeSize.get(node.left)+subtreeSize.get(node.right);
        subtreeSize.put(node, currSize);
    }
    public long getMaxProd(TreeNode node, long size){
        if(node == null)
            return 0;
        long currSize = subtreeSize.get(node);
        return Math.max((size-currSize)*currSize, Math.max(getMaxProd(node.left, size), getMaxProd(node.right, size)));
    }
    public int maxProduct(TreeNode root) {
        int MOD = (int)(1e9+7);
        subtreeSize = new HashMap<>();
        subtreeSize.put(null, (long)0);
        calcSize(root);
        return (int)(getMaxProd(root, subtreeSize.get(root))%MOD);
    }
}
