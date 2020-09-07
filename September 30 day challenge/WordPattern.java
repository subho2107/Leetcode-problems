import java.io.*;
import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hashMap = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int pos = 0; pos < words.length; pos++) {
            char ch = pattern.charAt(pos);
            if (!hashMap.containsKey(ch) && !set.contains(words[pos])) {
                hashMap.put(ch, words[pos]);
                set.add(words[pos]);
            } else if (hashMap.containsKey(ch)) {
                if (!hashMap.get(ch).equals(words[pos]))
                    return false;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    }
}
