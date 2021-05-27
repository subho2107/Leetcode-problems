import java.io.*;
import java.util.*;

public class FindTheShortestSuperstring {
    public String shortestSuperstring(String[] words) {
        Map<String, String> map = new HashMap<>();
        int n = words.length, mask = (1<<n)-1;
        return shortestSuperstringUtil(words, "", mask, map);
    }
    public String shortestSuperstringUtil(String[]words, String start, int mask, Map<String, String> map){
        if(mask == 0)
            return start;
        String key = start+"-"+mask;
        if(map.containsKey(key))
            return map.get(key);
        String shortest = "";
        int n = words.length;
        for(int i = 0; i < n; i++){
            if(((mask >> i)&1) != 0){
                String superstring = shortestSuperstringUtil(words, words[i], mask&(~(1<<i)), map);
                String merged = merge(start, superstring);
                if(shortest.length() == 0 || shortest.length() > merged.length())
                    shortest = merged;
            }
        }
        map.put(key, shortest);
        return shortest;
    }
    public String merge(String a, String b){
        for(int i = Math.max(1, a.length() - b.length()); i < a.length(); i++) {
            boolean match = true;
            for(int j = i; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j - i)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return a.substring(0, i) + b;
            }
        }
        return a + b;
    }
}
