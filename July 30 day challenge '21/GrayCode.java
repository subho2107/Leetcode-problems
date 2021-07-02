import java.io.*;
import java.util.*;

public class GrayCode {
    //using dfs
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
    //using pattern
    public void grayCodeUtil(int n, List<Integer>list){
        if(n == 0){
            list.add(0);
            return;
        }
        grayCodeUtil(n-1, list);
        int mask = 1<<(n-1);
        for(int i = list.size()-1; i >= 0; i--){
            list.add(list.get(i)+mask);
        }
    }
    public List<Integer> grayCode2(int n) {
        List<Integer>list = new ArrayList<>();
        grayCodeUtil(n, list);
        return list;
    }
}
