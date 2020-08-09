import java.io.*;
import java.util.*;

public class PathSumIII {
    int cnt;
    public void dfs(TreeNode node, int sum){
        if (node!=null) {
            if(node.val==sum)
                cnt++;
            sum -= node.val;
            dfs(node.left, sum);
            dfs(node.right, sum);
        }

    }
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        cnt = 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeNode a = new TreeNode(5);
        a.left = new TreeNode(4);
        System.out.println(new PathSumIII().pathSum(a, 0));
        System.out.println(sb);
    }
}
