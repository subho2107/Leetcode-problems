import java.io.*;
import java.util.*;

public class CriticalConnectionsInANetwork {
    int time;
    int [] disc, low;
    List<Integer>[]adj;
    List<List<Integer>>ans;
    public void findSCC(int vertex, int prev){
        disc[vertex] = time;
        low[vertex] = time;
        time++;
        for(int neighbour : adj[vertex]){
            if(disc[neighbour] == -1){
                findSCC(neighbour, vertex);
                low[vertex] = Math.min(low[vertex], low[neighbour]);
            }
            else if(neighbour != prev)
                low[vertex] = Math.min(low[vertex], disc[neighbour]);
            if (low[neighbour] > disc[vertex])
                ans.add(Arrays.asList(vertex, neighbour));
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        time = 0;
        disc = new int[n];
        low = new int[n];
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for(List<Integer>edge : connections){
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        ans = new ArrayList<>();
        findSCC(0, -1);
        return ans;
    }
}
