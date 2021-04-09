import java.io.*;
import java.util.*;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        String [] dup = new String[n];
        for(int i = 0;i < n; i++)
            dup[i] = words[i];
        Arrays.sort(dup, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                for(int i = 0; i < Math.min(a.length(), b.length()); i++){
                    int posA = order.indexOf(a.charAt(i)), posB = order.indexOf(b.charAt(i));
                    if(posA != posB)
                        return posA > posB?1:-1;
                }
                if(a.length() != b.length())
                    return a.length() > b.length() ? 1 : -1;
                return 0;
            }
        });
        for(int i = 0; i < n; i++)
        {
            if(words[i] != dup[i])
                return false;
        }
        return true;
    }
}
