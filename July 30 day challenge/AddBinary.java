import java.io.*;
import java.util.*;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder zeroes = new StringBuilder();
        int n = a.length(), m = b.length();
        zeroes.append("0".repeat(Math.max(n, m) - Math.min(n, m)));
        if (n < m)
            a = zeroes.toString()+a;
        else
            b = zeroes.toString()+b;
        int carry = 0;
        System.out.println(a);
        System.out.println(b);
        StringBuilder ans = new StringBuilder();
        for (int pos = Math.max(n, m)-1; pos >= 0 ; pos--) {
            char ch = a.charAt(pos), ch2 = b.charAt(pos);
            int temp = Character.getNumericValue(ch)+Character.getNumericValue(ch2)+carry;
            if (temp ==2 || temp == 0)
            {
                ans.append('0');
            }
            else
                ans.append('1');
            if (temp == 2|| temp==3)
                carry = 1;
            else
                carry = 0;

        }
        if(carry == 1)
            ans.append(1);
        ans.reverse();
        if (ans.indexOf("1")==-1)
            return "0";
        return ans.toString().substring(ans.indexOf("1"));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String a ="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101" ;
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(new AddBinary().addBinary(a, b));
        System.out.println(sb);
    }
}
