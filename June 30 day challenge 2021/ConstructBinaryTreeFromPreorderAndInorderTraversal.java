import java.io.*;
import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1)
            return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int pos = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                pos = i;
                break;
            }
        }
        if(pos - 1 >= 0)
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+pos), Arrays.copyOfRange(inorder, 0, pos));
        if(pos + 1 < inorder.length)
            root.right = buildTree(Arrays.copyOfRange(preorder, 1+pos, preorder.length), Arrays.copyOfRange(inorder, pos+1, inorder.length));
        return root;
    }
}
