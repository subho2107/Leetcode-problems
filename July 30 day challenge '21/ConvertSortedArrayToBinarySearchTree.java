import java.io.*;
import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode formBST(int [] nums, int l, int r){
        if(r < l || l > nums.length)
            return null;
        if(l == r)
            return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode currRoot = new TreeNode(nums[mid]);
        currRoot.left = formBST(nums, l, mid-1);
        currRoot.right = formBST(nums, mid+1, r);
        return currRoot;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return formBST(nums, 0, nums.length-1);
    }
}
