import java.io.*;
import java.util.*;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> grouping = new HashMap<>();
        for(String path : paths){
            String [] temp = path.split(" ");
            String dir = temp[0];
            for(int i = 1; i < temp.length; i++){
                String file = temp[i];
                int posBracket = file.indexOf('(');
                String text = file.substring(posBracket+1, file.length()-1);
                if(!grouping.containsKey(text))
                    grouping.put(text, new ArrayList<>());
                String location = dir+"/"+file.substring(0, posBracket);
                grouping.get(text).add(location);
            }
        }
        List<List<String>>ans = new ArrayList<>();
        for(List<String>group : grouping.values()){
            if(group.size() == 1)
                continue;
            ans.add(group);
        }
        return ans;
    }
}
