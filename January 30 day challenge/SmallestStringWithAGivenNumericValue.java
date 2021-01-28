import java.io.*;
import java.util.*;

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char [] arr = new char[n];
        Arrays.fill(arr, 'a');
        long sum = n-1;
        for(int i = n-1; i >= 0; i--){
            if(k-sum <= 26){
                arr[i] = (char)('a'+k-sum-1);
                break;
            }
            else{
                arr[i] = 'z';
                sum += 25;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char ch : arr)
            ans.append(ch);
        return ans.toString();
    }
}
