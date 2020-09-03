import java.io.*;
import java.util.*;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int pos = 0; pos < s.length()/2; pos++){
            String part = s.substring(0, pos+1);
            int len = part.length();
            if (s.length() % len != 0)continue;
            boolean check = true;
            for(int pos2 = pos+1; pos2+len <= s.length(); pos2+=len){
                if(!s.substring(pos2, pos2+len).equals(part)){
                    check = false;
                    break;
                }
            }
            if(check)
                return true;
        }
        return false;

    }
    public static void main(String[] args) throws Exception {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aabaaba"));
    }
}
