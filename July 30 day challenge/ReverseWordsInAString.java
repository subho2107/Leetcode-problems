import java.io.*;
import java.util.*;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String [] arr = s.split(" ");
        String res = "";
        for(String word: arr)
        {
            if(word.equals(""))continue;
            res = word +" "+res;
        }
        res = res.trim();
        return res;
    }
}
