public class SumOfLeftLeaves {
    int sum;

    public void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            if (node.left.right == null && node.left.left == null)
                sum += node.left.val;
            dfs(node.left);
        }
        if (node.right != null)
            dfs(node.right);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }
}
