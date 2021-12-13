import java.io.*;
import java.util.*;

public class ConsecutiveCharacters2 {
    public int maxPower(String s) {
        int n = s.length(), ans = 1;
        int prev = 1, curr = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i-1))
                curr = prev+1;
            else
                curr = 1;
            ans = Math.max(ans, curr);
            prev = curr;
        }
        return ans;
    }
}
