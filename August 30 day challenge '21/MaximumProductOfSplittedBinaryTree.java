import java.io.*;
import java.util.*;

public class MaximumProductOfSplittedBinaryTree {
    long ans,total;
    public long getMaxProd(TreeNode node){
        if(node == null)
            return 0;
        long currVal = node.val;
        long left = getMaxProd(node.left);
        long right = getMaxProd(node.right);
        currVal += left+right;
        ans = Math.max(ans, Math.max((total-left)*left, (total-right)*right));
        return currVal;
    }
    public int maxProduct(TreeNode root) {
        int MOD = (int)(1e9+7);
        ans = 0;
        total = 0;
        total = getMaxProd(root);
        getMaxProd(root);
        return (int)(ans%MOD);
    }
}
