import java.io.*;
import java.util.*;

public class UniqueBinarySearchTrees {
    //time complexity:O(n^2)
    //space complexity:O(n)
    HashMap<Integer, HashMap<Integer, Integer>>prev;
    public int getUniqueBSTs(int left, int right){
        if(left > right)
            return 1;
        if(prev.containsKey(left) && prev.get(left).containsKey(right))
            return prev.get(left).get(right);
        int sum = 0;
        for(int root = left; root <= right; root++){
            sum += getUniqueBSTs(left, root-1)*getUniqueBSTs(root+1, right);
        }
        if(!prev.containsKey(left))
            prev.put(left, new HashMap<>());
        prev.get(left).put(right, sum);
        return sum;
    }
    public int numTrees(int n) {
        prev = new HashMap<>();
        return getUniqueBSTs(1, n);
    }
    //time complexity:O(n^2)
    //space complexity:O(n)
    int [] dp;
    public int numTreesUtil(int n){
        if(n <= 1)
            return 1;
        if(dp[n] != 0)
            return dp[n];
        for(int i = 1; i <= n; i++)
            dp[n] += numTreesUtil(i-1)*numTreesUtil(n-i);
        return dp[n];
    }
    public int numTrees2(int n) {
        dp = new int[n+1];
        return numTreesUtil(n);
    }
}
