import java.io.*;
import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String [] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                if (num1.equals(num2))
                    return 0;
                while (num1.length()!=0 && num2.length()!=0)
                {
                    for (int i = 0; i < Math.min(num1.length(), num2.length()); i++) {
                        int dig1 = Character.getNumericValue(num1.charAt(i ));
                        int dig2 = Character.getNumericValue(num2.charAt(i));
                        if (dig1 > dig2)
                            return 1;
                        else if (dig2 > dig1)
                            return -1;
                    }
                    if (num1.length()>num2.length())
                        num1 = num1.substring(num2.length());
                    else
                        num2 = num2.substring(num1.length());
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for (String num : arr) {
            res.insert(0, num);
        }
        if(res.charAt(0)=='0') {
            return "0";
        }
        return res.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = {824,938,1399,5607,6973,5703,9609,4398,8247};
        System.out.println(new LargestNumber().largestNumber(arr));
    }
}
