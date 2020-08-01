import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumWidthOfABinaryTree {
    int maxWidth = 0;
    Map<Integer, Integer> leftmostNodePosition = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0, 0);
        return maxWidth;
    }

    public void dfs(TreeNode root, int depth, int position) {
        if (root == null) return;
        leftmostNodePosition.putIfAbsent(depth, position);
        maxWidth = Math.max(maxWidth, position - leftmostNodePosition.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * position);
        dfs(root.right, depth + 1, 2 * position + 1);
    }
}
