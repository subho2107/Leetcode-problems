import java.io.*;
import java.util.*;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

public class SerializeAndDeserializeBST {
    public static void main(String[] args) throws Exception {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans.val);
        if (ans.left!=null)
            System.out.println("left "+ans.left.val);
        if (ans.right!=null)
            System.out.println("right "+ans.right.val);
    }
}

class Codec {
    public String serializeUtil(TreeNode root, String ans) {
        if (root == null)
            return ans;
        ans += root.val + " ";
        ans = serializeUtil(root.left, ans);
        ans = serializeUtil(root.right, ans);
        return ans;
    }

    public void deserializeUtil(TreeNode root, String data) {
        if (data.equals(" ") || data.equals(""))
            return;
        String[] arr = data.split(" ");
        root.val = Integer.parseInt(arr[0]);
        String left = "", right = "";
        for (int pos = 1; pos < arr.length; pos++) {
            String val = arr[pos];
            if (Integer.parseInt(val) < root.val) {
                left += val + " ";
            } else {
                right += val + " ";
            }
        }
        if (!left.equals("")) {
            root.left = new TreeNode();
            deserializeUtil(root.left, left);
        }
        if (!right.equals("")) {
            root.right = new TreeNode();
            deserializeUtil(root.right, right);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        return serializeUtil(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        TreeNode root = new TreeNode();
        deserializeUtil(root, data);
        return root;
    }
}