import java.io.*;
import java.util.*;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer>freq = new HashMap<>();
        for(int i = 0; i <= s.length()-10; i++){
            String subs = s.substring(i, i+10);
            freq.put(subs, freq.getOrDefault(subs, 0)+1);
        }
        List<String>res = new ArrayList<>();
        for(String key : freq.keySet()){
            if(freq.get(key)>= 2)
                res.add(key);
        }
        return res;
    }
}
