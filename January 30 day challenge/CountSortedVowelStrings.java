import java.io.*;
import java.util.*;

public class CountSortedVowelStrings {
    public int getCntRecurse(int currLen, int pos){
        if(pos == 4 || currLen == 0)
            return 1;
        int cnt = getCntRecurse(currLen-1, pos);
        for (int i = pos+1; i < 5; i++) {
            cnt += getCntRecurse(currLen-1, i);
        }
        return cnt;
    }
    public int countVowelStrings(int n) {
        int cnt = 0;
        for(int i = 0; i < 5; i++){
            cnt += getCntRecurse(n-1, i);
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(33));
    }
}
