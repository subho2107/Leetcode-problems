import java.io.*;
import java.util.*;

public class GroupingAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>>groupingAnagrams = new HashMap<>();
        for(String s : strs){
            int [] freq = new int[26];
            for(char ch : s.toCharArray())
                freq[ch - 'a']++;
            groupingAnagrams.computeIfAbsent(Arrays.toString(freq),x->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groupingAnagrams.values());
    }
}
