import java.io.*;
import java.util.*;

public class DeleteNodeInABST {
    public int getMinVal(TreeNode root) {
        int val = root.val;
        while (root.left != null) {
            val = root.left.val;
            root = root.left;
        }
        return val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val)
            root.left = this.deleteNode(root.left, key);
        else if (key > root.val)
            root.right = this.deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.val = this.getMinVal(root.right);
            root.right = this.deleteNode(root.right, root.val);
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
