import java.io.*;
import java.util.*;

public class HouseRobberIII2 {
    private Map<TreeNode, Integer>maxProfit;
    private int getChildProfit(TreeNode child){
        if(child != null)
            return getMaxProfit(child.left)+getMaxProfit(child.right);
        return 0;
    }
    private int getMaxProfit(TreeNode node){
        if(node == null)
            return 0;
        if(!maxProfit.containsKey(node)){
            TreeNode leftChild = node.left, rightChild = node.right;
            int leftGrandChildren = getChildProfit(leftChild), rightGrandChildren = getChildProfit(rightChild);
            int nonSkippedProfit = node.val+leftGrandChildren+rightGrandChildren, skippedProfit = getMaxProfit(leftChild)+getMaxProfit(rightChild);
            int robbedVal = Math.max(skippedProfit, nonSkippedProfit);
            maxProfit.put(node, robbedVal);
        }
        return maxProfit.get(node);
    }
    public int rob(TreeNode root) {
        maxProfit = new HashMap<>();
        return getMaxProfit(root);
    }
}
