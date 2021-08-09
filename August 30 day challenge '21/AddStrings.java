import java.io.*;
import java.util.*;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        char [] ans = new char [n];
        int carry = 0;
        for(int i = n-1, j = num1.length()-1, k = num2.length()-1; i >= 0; i--, j--, k--){
            int a, b;
            if(j < 0)
                a = 0;
            else
                a = Character.getNumericValue(num1.charAt(j));
            if(k < 0)
                b = 0;
            else
                b = Character.getNumericValue(num2.charAt(k));
            int sum = a+b+carry;
            ans[i] = Integer.toString(sum%10).charAt(0);
            carry = sum/10;
        }
        String temp = String.valueOf(ans);
        if(carry != 0)
            return Integer.toString(carry)+temp;
        else
            return temp;
    }
}
