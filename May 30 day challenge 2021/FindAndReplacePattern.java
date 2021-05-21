import java.io.*;
import java.util.*;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int n = pattern.length();
        HashMap<Character, Character> map = new HashMap<>();
        char [] patternArr = pattern.toCharArray();
        for(String word : words){
            char [] arr = word.toCharArray();
            HashSet<Character>values = new HashSet<>();
            map.clear();
            boolean check = true;
            for(int i = 0; i < n; i++){
                boolean contains = map.containsKey(arr[i]);
                if(!contains && values.add(patternArr[i]))
                    map.put(arr[i], patternArr[i]);
                else if(!(contains && map.get(arr[i]) == patternArr[i])){
                    check = false;
                    break;
                }
            }
            if(check)
                ans.add(word);
        }
        return ans;
    }
}
