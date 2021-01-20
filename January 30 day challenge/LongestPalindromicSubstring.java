import java.io.*;
import java.util.*;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        String maxString = " ";
        for(int mid = 0; mid < s.length(); mid++){
            int i = mid, j = mid;
            while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if(j-i-1 > maxLen){
                maxLen = j - i - 1;
                maxString = s.substring(i+1, j);
            }
            i = mid; j = mid+1;
            while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            if(j-i-1 > maxLen){
                maxLen = j - i - 1;
                maxString = s.substring(i+1, j);
            }
        }
        return maxString;
    }
}
