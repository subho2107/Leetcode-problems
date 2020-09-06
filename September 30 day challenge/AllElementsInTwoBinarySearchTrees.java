import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    public void dfs(TreeNode vertex, List<Integer> nodes) {
        if (vertex == null) return;
        if (vertex.left != null)
            dfs(vertex.left, nodes);
        nodes.add(vertex.val);
        if (vertex.right != null)
            dfs(vertex.right, nodes);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        for (int num : list2)
            list1.add(num);
        Collections.sort(list1);
        return list1;
    }
}
