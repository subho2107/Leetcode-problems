import java.io.*;
import java.util.*;

public class OpenTheLock {
    HashSet<String>deadLineSet;
    public ArrayList<String> getNeighbours(String s){
        char [] arr = s.toCharArray();
        ArrayList<String>neighbours = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int orig = Character.getNumericValue(arr[i]);
            int lesser, greater;
            lesser = orig-1;
            if(lesser == -1)
                lesser = 9;
            greater = orig+1;
            if(greater == 10)
                greater = 0;
            char [] a = Arrays.copyOf(arr, 4), b = Arrays.copyOf(arr, 4);
            a[i] = Integer.toString(lesser).charAt(0);
            b[i] = Integer.toString(greater).charAt(0);
            neighbours.add(String.valueOf(a));
            neighbours.add(String.valueOf(b));
        }
        return neighbours;
    }
    public int openLock(String[] deadends, String target) {
        deadLineSet = new HashSet<>();
        for(String s : deadends)
            deadLineSet.add(s);
        if(deadLineSet.contains("0000"))
            return -1;
        Queue<String>queue = new LinkedList<>();
        queue.add("0000");
        for(int steps = 0; !queue.isEmpty() ; steps++){
            for(int i = queue.size(); i >= 1; i--){
                String curr = queue.poll();
                if(curr.equals(target))
                    return steps;
                for(String neighbour : getNeighbours(curr)){
                    if(deadLineSet.contains(neighbour))
                        continue;
                    deadLineSet.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return -1;
    }
}
