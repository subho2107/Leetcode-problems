import java.io.*;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set = new HashSet<>(wordDict);
        if (set.contains(s))return true;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0,i)) && wordBreak(s.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = {"aaaa","aaa"};
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList(arr)));
    }
}
