import java.io.*;
import java.util.*;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        HashSet<Character>vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
        int firstHalf = 0, secHalf = 0, n = s.length();
        for(int i = 0; i < n; i++){
            if(vowels.contains(s.charAt(i))){
                if(i < n/2)
                    firstHalf++;
                else
                    secHalf++;
            }
        }
        return firstHalf == secHalf;
    }
}
