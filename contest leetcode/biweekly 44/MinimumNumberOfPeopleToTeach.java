import java.io.*;
import java.util.*;

public class MinimumNumberOfPeopleToTeach {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        HashSet<Integer>[]langSet = new HashSet[m];
        for(int i = 0; i < m; i++){
            langSet[i] = new HashSet<>();
            for(int language : languages[i])
                langSet[i].add(language);
        }
        HashSet<Integer>cantTalk = new HashSet<>();
        for(int [] friend : friendships){
            int u = friend[0]-1, v = friend[1]-1;
            if(Collections.disjoint(langSet[u], langSet[v])){
                cantTalk.add(u);
                cantTalk.add(v);
            }
        }
        HashMap<Integer, Integer>freq = new HashMap<>();
        for(int person : cantTalk){
            for(int language : langSet[person]){
                freq.put(language, freq.getOrDefault(language, 0)+1);
            }
        }
        int maxFreq = 0;
        for(int cnt : freq.values())
            maxFreq = Math.max(maxFreq, cnt);
        return cantTalk.size()-maxFreq;
    }
}
