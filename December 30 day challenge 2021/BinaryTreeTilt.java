import java.io.*;
import java.util.*;

public class BinaryTreeTilt {
    private int ans;
    private int getSubtreeSum(TreeNode node){
        if(node == null)
            return 0;
        int left = getSubtreeSum(node.left), right = getSubtreeSum(node.right);
        ans += Math.abs(left - right);
        return left+right+node.val;
    }
    public int findTilt(TreeNode root) {
        ans = 0;
        getSubtreeSum(root);
        return ans;
    }
}
