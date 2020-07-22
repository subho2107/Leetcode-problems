import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<TreeNode>> zigzagNodes = new ArrayList<>();
        List<List<Integer>> zigzagVals = new ArrayList<>();
        if (root == null)
            return zigzagVals;
        zigzagNodes.add(new ArrayList<>());
        zigzagNodes.get(zigzagNodes.size() - 1).add(root);
        while (true) {
            List<TreeNode> currLevel = new ArrayList<>();
            for (TreeNode node :
                    zigzagNodes.get(zigzagNodes.size() - 1)) {
                if (node.left != null)
                    currLevel.add(node.left);
                if (node.right != null)
                    currLevel.add(node.right);
            }
            if (currLevel.size() == 0)
                break;
            zigzagNodes.add(currLevel);
        }
        for (int pos = 0; pos < zigzagNodes.size(); pos++) {
            List<Integer> currLevel = new ArrayList<>();
            for (TreeNode node :
                    zigzagNodes.get(pos)) {
                currLevel.add(node.val);
            }
            if (pos % 2 == 1)
                Collections.reverse(currLevel);
            zigzagVals.add(currLevel);
        }
        return zigzagVals;
    }
}
