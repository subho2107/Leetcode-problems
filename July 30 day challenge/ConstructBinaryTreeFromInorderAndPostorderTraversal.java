import java.io.*;
import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static int getPos(int[] arr, int val) {
        for (int pos = 0; pos < arr.length; pos++) {
            if (arr[pos] == val) return pos;
        }
        return -1;
    }

    public TreeNode buildTreeUtil(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        int rootPos = getPos(inorder, rootVal);
        TreeNode root = new TreeNode(rootVal);
        TreeNode left = buildTreeUtil(Arrays.copyOfRange(inorder, 0, rootPos),
                Arrays.copyOfRange(postorder, 0, rootPos));
        TreeNode right = buildTreeUtil(Arrays.copyOfRange(inorder, rootPos + 1, inorder.length),
                Arrays.copyOfRange(postorder, rootPos, inorder.length - 1));
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int maxVal = 0;
        for (int pos = 0; pos < inorder.length; pos++) {
            maxVal = Math.max(maxVal, inorder[pos]);
        }
        return buildTreeUtil(inorder, postorder);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}).val);
    }
}
