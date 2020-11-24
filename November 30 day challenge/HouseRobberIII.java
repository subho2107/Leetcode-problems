import java.io.*;
import java.util.*;

public class HouseRobberIII {
    public int dfs(TreeNode node, int state) {
        if (node == null)
            return 0;
        if (state == 0)
            return dfs(node.left, 1) + dfs(node.right, 1);
        else
            return Math.max(node.val+dfs(node.left, 0)+dfs(node.right, 0), dfs(node.left, 1)+dfs(node.right, 1));

    }

    public int rob(TreeNode root) {
        return Math.max(dfs(root, 1), dfs(root, 0));
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(new HouseRobberIII().rob(root));
    }
}
