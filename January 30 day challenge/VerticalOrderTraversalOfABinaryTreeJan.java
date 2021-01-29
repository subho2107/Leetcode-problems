import java.io.*;
import java.util.*;

public class VerticalOrderTraversalOfABinaryTreeJan {
    HashMap<TreeNode, Integer>levels;
    TreeMap<Integer, List<TreeNode>>groupingOnX;
    public void dfs(TreeNode node, int level, int x){
        if(node == null)
            return;
        levels.put(node, level);
        if(!groupingOnX.containsKey(x)){
            groupingOnX.put(x, new ArrayList<>());
        }
        groupingOnX.get(x).add(node);
        dfs(node.left, level+1, x-1);
        dfs(node.right, level+1, x+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        levels = new HashMap<>();
        groupingOnX = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>>ans = new ArrayList<>();
        for(List<TreeNode> list : groupingOnX.values())
        {
            Collections.sort(list, (a, b)->{
                int levDiff = levels.get(a) - levels.get(b);
                if(levDiff != 0)
                    return levDiff;
                return a.val - b.val;
            });
            List<Integer>temp = new ArrayList<>();
            for(TreeNode node : list)
                temp.add(node.val);
            ans.add(temp);
        }
        return ans;

    }
}
