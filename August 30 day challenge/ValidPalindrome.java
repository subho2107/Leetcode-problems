import java.io.*;
import java.util.*;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String dup = "";
        s = s.toLowerCase();
        for (char ch:s.toCharArray())
            if ((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
                dup += ch;
        int n = dup.length();
        for (int pos = 0; pos < n / 2; pos++) {
            if (dup.charAt(pos)!=dup.charAt(n-pos-1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }
}
