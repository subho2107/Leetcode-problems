import java.io.*;
import java.util.*;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer>pos = new LinkedList<>();
        int n = arr.length;
        pos.add(start);
        HashSet<Integer>visited = new HashSet<>();
        while (!pos.isEmpty()){
            int i = pos.remove();
            visited.add(i);
            if (arr[i] == 0)
                return true;
            if(arr[i]+i < n && !visited.contains(arr[i]+i))
                pos.add(arr[i]+i);
            if(i-arr[i] >= 0 && !visited.contains(i-arr[i]))
                pos.add(i-arr[i]);
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        int [] arr = {3,0,2,1,2};
        int start = 2;
        System.out.println(new JumpGameIII().canReach(arr, start));
    }
}
