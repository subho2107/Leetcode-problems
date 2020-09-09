import java.io.*;
import java.util.*;

public class SumOfRootToLeafBinaryNumbers {
    int sum;

    public void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num << 1 | root.val;
        if (root.left == null && root.right == null)
            sum += num;
        if (root.left != null)
            dfs(root.left, num);
        if (root.right != null)
            dfs(root.right, num);
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
