import java.io.*;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>>levels = new ArrayList<>();
        levels.add(new ArrayList<>());
        levels.get(0).add(root);
        while(true && root != null){
            List<TreeNode>curr = new ArrayList<>();
            for(TreeNode node : levels.get(levels.size() - 1)){
                if(node.left != null)
                    curr.add(node.left);
                if(node.right != null)
                    curr.add(node.right);
            }
            if(curr.size() == 0)
                break;
            levels.add(curr);
        }
        List<List<Integer>>ans = new ArrayList<>();
        for(List<TreeNode> curr : levels){
            List<Integer>level = new ArrayList<>();
            if(root == null)
                return ans;
            for(TreeNode node : curr)
                level.add(node.val);
            ans.add(level);
        }
        return ans;
    }
}
