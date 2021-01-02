import java.io.*;
import java.util.*;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    static ArrayList<Character>path;
    static boolean found;
    public static void dfs(final TreeNode node, final TreeNode target){
        if(node == target){
            found = true;
            return;
        }
        if(node.left != null)
        {
            path.add('L');
            dfs(node.left, target);
            if(found)
                return;
            path.remove(path.size()-1);
        }
        if(node.right != null)
        {
            path.add('R');
            dfs(node.right, target);
            if(found)
                return;
            path.remove(path.size()-1);
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        path = new ArrayList<>();
        found = false;
        dfs(original, target);
        TreeNode node = cloned;
        for(char move : path){
            if(move == 'L')
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
}
