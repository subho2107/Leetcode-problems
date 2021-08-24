import java.io.*;
import java.util.*;

public class TwoSumIVInputIsABST {
    public boolean dfs(TreeNode node, int k, Set<Integer>prev)
    {
        if(node == null)
            return false;
        boolean found = dfs(node.left, k, prev) || dfs(node.right, k, prev) || prev.contains(k - node.val);
        prev.add(node.val);
        return found;
    }
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }
}
