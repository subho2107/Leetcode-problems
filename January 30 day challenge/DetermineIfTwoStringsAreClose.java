import java.io.*;
import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer>h1 = new HashMap<>(), h2 = new HashMap<>();
        for(char ch : word1.toCharArray()){
            h1.put(ch, h1.getOrDefault(ch, 0)+1);
        }
        for(char ch : word2.toCharArray()){
            h2.put(ch, h2.getOrDefault(ch, 0)+1);
        }
        HashSet<Integer>s1 = new HashSet<>(h1.values()), s2 =new HashSet<>(h2.values());
        return s1.equals(s2)&&h1.keySet().equals(h2.keySet());
    }
}
