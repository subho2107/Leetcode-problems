import java.io.*;
import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
  }

public class VerticalOrderTraversalOfABinaryTree {
    HashMap<Integer, int[]>coordinates ;
    public void dfs(TreeNode root, int x, int y){
        if(root == null)return;
        if(root.left != null)
            dfs(root.left, x-1, y+1);
        if(root.right != null)
            dfs(root.right, x+1, y+1);
        coordinates.put(root.val, new int[]{x, y});

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        coordinates = new HashMap<>();
        dfs(root, 0, 0);
        ArrayList<Integer>values = new ArrayList<>(coordinates.keySet());
        Collections.sort(values, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                int xDiff = coordinates.get(a)[0]-coordinates.get(b)[0];
                int yDiff = coordinates.get(a)[1]-coordinates.get(b)[1];
                if(xDiff!=0)
                    return xDiff;
                else if(yDiff != 0)
                    return yDiff;
                else
                    return a-b;
            }
        });
        List<List<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        for(int pos = 0; pos < values.size(); pos++){
            if(pos==0){
                temp = new ArrayList<>();
                temp.add(values.get(pos));
            }
            else{
                if(coordinates.get(values.get(pos))[0]==coordinates.get(values.get(pos-1))[0])
                    temp.add(values.get(pos));
                else{
                    ArrayList<Integer>curr = new ArrayList<>(temp);
                    ans.add(curr);
                    temp = new ArrayList<>();
                    temp.add(values.get(pos));
                }
            }
        }
        ArrayList<Integer>curr = new ArrayList<>(temp);
        ans.add(curr);
        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(node).toString());
        System.out.println(sb);
    }
}
