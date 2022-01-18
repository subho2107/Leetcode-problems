import java.util.*;
public class WordPatternJan22 {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        int patternLen = pattern.length(), sLen = arr.length;
        if(patternLen != sLen)
            return false;
        Map<Character, String>map = new HashMap<>();
        Set<String>wordsSet = new HashSet<>();
        for(int i = 0; i < sLen; i++){
            char ch = pattern.charAt(i);
            boolean keyExists = map.containsKey(ch);
            if((keyExists && !map.get(ch).equals(arr[i])) || (!keyExists && !wordsSet.add(arr[i]))){
                return false;
            }
            else if(!keyExists)
                map.put(ch, arr[i]);
        }
        return true;
    }
}
