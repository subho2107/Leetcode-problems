import java.io.*;
import java.util.*;

public class consecutiveCharacters {
    public int maxPower(String s) {
        int ans = 0, n = s.length();
        for(int i =0; i < n; i++){
            char ch = s.charAt(i);
            int cnt = 0;
            for(int j = i; j < n && s.charAt(j) == ch; j++)
                cnt++;
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}
