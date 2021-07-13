import java.io.*;
import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character>map = new HashMap<>();
        HashSet<Character>used = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i), ch2 = t.charAt(i);
            if(!map.containsKey(ch) && !used.contains(ch2))
                map.put(ch, ch2) ;
            else if(!(map.containsKey(ch) && map.get(ch) == ch2))
                return false;
            used.add(ch2);
        }
        return true;
    }
}
