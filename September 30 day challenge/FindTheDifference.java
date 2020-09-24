import java.io.*;
import java.util.*;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer>set = new HashMap<>();
        for(char ch: s.toCharArray())
        {
            set.put(ch, set.getOrDefault(ch, 0)+1);
        }
        HashMap<Character, Integer>set2 = new HashMap<>();
        for(char ch: t.toCharArray())
        {
            set2.put(ch, set2.getOrDefault(ch, 0)+1);
        }
        for(char ch:set2.keySet()){
            if(!set.containsKey(ch) || set.get(ch)!=set2.get(ch))
                return ch;
        }
        return 'a';
    }
}
