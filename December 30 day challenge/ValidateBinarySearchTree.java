import java.io.*;
import java.util.*;

public class ValidateBinarySearchTree {
    ArrayList<Integer>list;
    public void dfs(TreeNode node){
        if(node == null)
            return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
}
