import java.io.*;
import java.util.*;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        int sum = root.val >= low && root.val <= high?root.val:0;
        if(root.val > low)
            sum += rangeSumBST(root.left, low, high);
        if(root.val < high)
            sum += rangeSumBST(root.right, low, high);
        return sum;
    }
}
