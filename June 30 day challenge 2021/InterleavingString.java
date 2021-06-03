import java.io.*;
import java.util.*;

public class InterleavingString {
    public boolean isInterleavedUtil(String s1, String s2, int turn, String s3) {
        int posS1 = 0, posS2 = 0;
        StringBuilder sb = new StringBuilder();
        int n = s3.length();
        for (int i = 0; i < n; i++) {
            if (turn == 1 && s1.startsWith(s3.charAt(i)+"", posS1)) {
                while (i < n && s1.startsWith(sb.toString(), posS1)) {
                    sb.append(s3.charAt(i));
                    i++;
                }

                if (s1.startsWith(sb.toString(), posS1)) {
                    i--;
                }
                else {
                    i-=2;
                    posS1--;
                }
                posS1 += sb.length();
                turn ^= 1;
            } else if (turn == 0 && s2.startsWith(s3.charAt(i)+"", posS2)){
                while (i < n && s2.startsWith(sb.toString(), posS2)) {
                    sb.append(s3.charAt(i));
                    i++;
                }

                if (s2.startsWith(sb.toString(), posS2))
                    i--;
                else {
                    i -= 2;
                    posS2--;
                }
                posS2 += sb.length();
                turn ^= 1;

            }
            else
                return false;
            sb.setLength(0);
        }
        return posS1 == s1.length() && posS2 == s2.length();
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleavedUtil(s1, s2, 0, s3) || isInterleavedUtil(s1, s2, 1, s3);
    }

}
