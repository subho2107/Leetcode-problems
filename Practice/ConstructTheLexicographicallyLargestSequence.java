import java.io.*;
import java.util.*;

public class ConstructTheLexicographicallyLargestSequence {
    int [] ans;
    public boolean backtrack(int pos , HashSet<Integer>set, int n){
        if(set.size() == n)
            return true;
        if(pos > ans.length - 1)
            return false;
        if(ans[pos] != 0)
            return backtrack(pos+1, set, n);
        for(int i = n;i >= 1 ;i--){
            if(!set.contains(i) && (i == 1 ||(pos+i < ans.length && ans[pos+i] == 0))){
                set.add(i);
                ans[pos] = i;
                if(i != 1)
                    ans[pos+i] = i;
                if(backtrack(pos+1, set, n))
                    return true;
                set.remove(i);
                ans[pos] = 0;
                if(i != 1)
                    ans[pos+i] = 0;
            }
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        ans = new int[2*(n-1) + 1];
        HashSet<Integer>set = new HashSet<>();
        backtrack(0, set, n);
        return ans;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new ConstructTheLexicographicallyLargestSequence().constructDistancedSequence(3)));
    }
}
