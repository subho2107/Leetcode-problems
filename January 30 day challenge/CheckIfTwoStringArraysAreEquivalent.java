import java.io.*;
import java.util.*;

public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a = "", b = "";
        for(String word : word1)
            a += word;
        for(String word : word2)
            b += word;
        if(a.equals(b))
            return true;
        return false;
    }
}
