import java.io.*;
import java.util.*;
public class AllElementsInTwoBinarySearchTreesJan22 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode>stack1 = new Stack<>(), stack2 = new Stack<>();
        List<Integer>ans = new ArrayList<>();
        TreeNode curr1 = root1, curr2 = root2;
        while(curr1 != null || curr2 != null || !stack1.isEmpty() || !stack2.isEmpty()){
            while(curr1 != null){
                stack1.add(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                stack2.add(curr2);
                curr2 = curr2.left;
            }
            boolean isStack1Empty = stack1.isEmpty(), isStack2Empty = stack2.isEmpty();
            if((!isStack1Empty && !isStack2Empty && stack1.peek().val < stack2.peek().val) || isStack2Empty){
                curr1 = stack1.pop();
                ans.add(curr1.val);
                curr1 = curr1.right;
            }
            else{
                curr2 = stack2.pop();
                ans.add(curr2.val);
                curr2 = curr2.right;
            }
        }
        return ans;
    }
}
