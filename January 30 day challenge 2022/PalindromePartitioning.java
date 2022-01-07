import java.io.*;
import java.util.*;

public class PalindromePartitioning {
    private boolean [][] isPalinDP;
    private void partitionHelper(int start, String s, List<String>curr, List<List<String>>ans){
        if(start == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(s.charAt(start) == s.charAt(end) && (end-start <= 2 || isPalinDP[start+1][end-1])){
                isPalinDP[start][end] = true;
                curr.add(s.substring(start, end+1));
                partitionHelper(end+1, s, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        isPalinDP = new boolean[n][n];
        List<String>list = new ArrayList<>();
        List<List<String>>ans = new ArrayList<>();
        partitionHelper(0, s, list, ans);
        return ans;
    }
}
