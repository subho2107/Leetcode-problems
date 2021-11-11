import java.io.*;
import java.util.*;

public class SumRootToLeafNumbers {
    int sum;
    public void sumNumbersHelper(TreeNode root, int num){
        if(root == null)
            return;
        num = num*10 + root.val;
        if(root.left == null && root.right == null){
            sum += num;
            return;
        }
        sumNumbersHelper(root.left, num);
        sumNumbersHelper(root.right, num);
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumNumbersHelper(root, 0);
        return sum;
    }
}
