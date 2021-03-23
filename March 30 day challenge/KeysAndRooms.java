import java.io.*;
import java.util.*;

public class KeysAndRooms {
    boolean[]visited;
    public void dfs(int vertex, List<List<Integer>> rooms){
        if(visited[vertex])
            return;
        visited[vertex] = true;
        for(int neighbour : rooms.get(vertex))
            dfs(neighbour, rooms);
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(0, rooms);
        for(boolean visit : visited){
            if(!visit)
                return false;
        }
        return true;
    }
}
