import java.io.*;
import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        ArrayList<Integer>temp = new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);
        ArrayList<TreeNode>prevLevel = new ArrayList<>();
        prevLevel.add(root);
        while(true)
        {
            boolean check = false;
            ArrayList<TreeNode>currLevel = new ArrayList<>();
            ans.add(new ArrayList<>());
            for(TreeNode node : prevLevel)
            {
                int lastIndex = ans.size()-1;
                if (node.left!=null) {
                    check = true;
                    currLevel.add(node.left);
                    ans.get(lastIndex).add(node.left.val);
                }
                if (node.right!=null) {
                    check = true;
                    currLevel.add(node.right);
                    ans.get(lastIndex).add(node.right.val);
                }
            }
            if (!check) {
                ans.remove(ans.size()-1);
                break;
            }
            prevLevel = (ArrayList<TreeNode>) currLevel.clone();
        }
        Collections.reverse(ans);
        return ans;
    }
}
