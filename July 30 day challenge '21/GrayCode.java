import java.io.*;
import java.util.*;

public class GrayCode {
    public boolean dfs(List<Integer>ans, int n, Set<Integer>used){
        if(ans.size() == (1<<n))
            return true;
        int currNum = ans.get(ans.size()-1);
        for(int i = 0; i < n; i++){
            int num = currNum ^ (1<<i);
            if(!used.add(num))
                continue;
            ans.add(num);
            if(dfs(ans, n, used))
                return true;
            ans.remove(ans.size()-1);
            used.remove(num);
        }
        return false;
    }
    public List<Integer> grayCode(int n) {
        List<Integer>list = new ArrayList<>();
        Set<Integer>used = new HashSet<>();
        list.add(0);
        used.add(0);
        dfs(list, n, used);
        return list;
    }
}
