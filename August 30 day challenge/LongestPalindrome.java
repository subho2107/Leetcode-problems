import java.io.*;
import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer>freq = new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        int length = 0;
        boolean check = false;
        for(char ch: freq.keySet()){
            if(freq.get(ch)%2==0)
                length += freq.get(ch);
            else{
                check = true;
                length+= freq.get(ch)-1;
            }
        }
        if(check)
            length++;
        return length;

    }
}
