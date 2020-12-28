import java.io.*;
import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1)
            return 0;
        HashMap<Integer, ArrayList<Integer>> nextEqualValPos = new HashMap<>();
        for (int pos = 0; pos < n; pos++) {
            if (!nextEqualValPos.containsKey(arr[pos]))
                nextEqualValPos.put(arr[pos], new ArrayList<>());
            nextEqualValPos.get(arr[pos]).add(pos);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int jumps = 0;
        while (!queue.isEmpty()) {
            Queue<Integer>next = new LinkedList<>();
            for (int vertex : queue) {
                if(vertex == n-1)
                    return jumps;
                for (int neighbour : nextEqualValPos.get(arr[vertex])) {
                    if (!visited.contains(neighbour)){
                        visited.add(neighbour);
                        next.add(neighbour);
                    }
                }
                int [] temp = {vertex+1, vertex-1};
                for (int i : temp) {
                    if (!visited.contains(i) && i < n && i >= 0)
                    {
                        visited.add(i);
                        next.add(i);
                    }
                }
                nextEqualValPos.get(arr[vertex]).clear();
            }
            queue = next;
            jumps++;
        }
        return -1;
    }
}
