import java.util.HashSet;
class BinaryTreeCameras {
    HashSet<TreeNode> monitored;
    int ans;
    public void getCnt(TreeNode node, TreeNode parent){
        if(node == null)
            return;
        getCnt(node.left, node);
        getCnt(node.right, node);
        if(parent == null && !monitored.contains(node) || !monitored.contains(node.left) || !monitored.contains(node.right))
        {
            ans++;
            monitored.add(node);
            monitored.add(parent);
            monitored.add(node.left);
            monitored.add(node.right);
        }
    }
    public int minCameraCover(TreeNode root) {
        ans = 0;
        monitored = new HashSet<>();
        monitored.add(null);
        getCnt(root, null);
        return ans;
    }
}