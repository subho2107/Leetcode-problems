import java.io.*;
import java.util.*;

public class PalindromePairs {
    public boolean isPalin(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--))return false;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer>positions = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            positions.put(words[i], i);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].equals("")){
                for(int j = 0; j < words.length; j++){
                    if(i == j)continue;
                    if(isPalin(words[j], 0, words[j].length()-1)){
                        ans.add(List.of(i, j));
                        ans.add(List.of(j, i));
                    }
                }
            }
            else{
                StringBuilder sb = new StringBuilder(words[i]);
                sb.reverse();
                String rev = sb.toString();
                if(positions.containsKey(rev)){
                    int pos = positions.get(rev);
                    if(pos != i)
                        ans.add(List.of(i, pos));
                }
                for(int j = 1; j < rev.length(); j++){
                    if(isPalin(rev, 0, j-1)  ){
                        String sub = rev.substring(j);
                        if(positions.containsKey(sub))
                            ans.add(List.of(i, positions.get(sub)));
                    }
                    if(isPalin(rev, j, rev.length()-1)){
                        String sub2 = rev.substring(0, j);
                        if(positions.containsKey(sub2))
                            ans.add(List.of(positions.get(sub2), i));
                    }
                }
            }
        }
        return ans;
    }
}
