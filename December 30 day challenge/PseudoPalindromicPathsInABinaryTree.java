import java.io.*;
import java.util.*;

public class PseudoPalindromicPathsInABinaryTree {
    int [] freq;
    int cnt = 0;
    public void dfs(TreeNode node){
        if(node == null)
            return;
        freq[node.val]++;
        if(node.left == null && node.right == null){
            int totalLength = 0, oddCnt = 0;
            for(int num : freq){
                totalLength += num;
                if(num % 2 == 1)
                    oddCnt++;
            }
            if(totalLength % 2 == 0 && oddCnt == 0)
                cnt++;
            else if(totalLength % 2 == 1 && oddCnt == 1)
                cnt++;
        }
        if(node.left != null)
            dfs(node.left);
        if(node.right != null)
            dfs(node.right);
        freq[node.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        freq = new int[10];
        dfs(root);
        return cnt;
    }
}
