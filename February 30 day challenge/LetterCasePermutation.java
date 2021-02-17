import java.io.*;
import java.util.*;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        int n = S.length();
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch))
                n--;
        }
        List<String>list = new ArrayList<>();
        for(int i = 0; i < (int)Math.pow(2, n); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0, k = 0; k < S.length(); k++){
                char ch = S.charAt(k);
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                    continue;
                }
                if((i&(1<<j)) > 0)
                    sb.append(Character.toUpperCase(ch));
                else
                    sb.append(ch);
                j++;
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2").toString());
    }
}
