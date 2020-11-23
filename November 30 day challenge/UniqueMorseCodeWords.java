import java.io.*;
import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String>hashSet = new HashSet<>();
        for (String word : words) {
            StringBuilder temp = new StringBuilder();
            for (char c : word.toCharArray()) {
                temp.append(codes[c - 'a']);
            }
            hashSet.add(temp.toString());
        }
        return hashSet.size();
    }
}
