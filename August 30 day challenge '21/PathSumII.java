import java.io.*;
import java.util.*;

public class PathSumII {
    public void dfs(TreeNode node, int sum, int targetSum, List<List<Integer>>ans, List<Integer>curr){
        if(node == null)
            return;
        sum += node.val;
        curr.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                ans.add(new ArrayList<>(curr));
            }
        }
        else{
            dfs(node.left, sum, targetSum, ans, curr);
            dfs(node.right, sum, targetSum, ans, curr);
        }
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>curr = new ArrayList<>();
        dfs(root, 0, targetSum, ans, curr);
        return ans;
    }
}
