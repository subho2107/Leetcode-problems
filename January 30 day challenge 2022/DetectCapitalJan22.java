import java.io.*;

public class DetectCapitalJan22 {
    public boolean detectCapitalUse(String word) {
        int caps = 0, n = word.length();
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch))
                caps++;
        }
        return caps == n || (caps == 1 && Character.isUpperCase(word.charAt(0)) && n > 1) || caps == 0;
    }
}
