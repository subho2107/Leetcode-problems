import java.io.*;
import java.util.*;

public class CourseSchedule {
    class Graph{
        int n;
        List<Integer>[]adj;
        Graph(int size){
            n = size;
            adj = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adj[i] = new ArrayList<>();
        }
        void addEdge(int src, int dst){
            adj[src].add(dst);
        }
        boolean hasCycleHelper(int vertex, boolean [] visited, boolean [] recStack){
            if(recStack[vertex])
                return true;
            if(visited[vertex])
                return false;
            visited[vertex] = true;
            recStack[vertex] = true;
            for(int neighbour : adj[vertex])
            {
                if(hasCycleHelper(neighbour, visited, recStack))
                    return true;
            }
            recStack[vertex] = false;
            return false;
        }
        boolean hasCycle(){
            boolean [] visited = new boolean[n], recStack = new boolean[n];
            for(int i = 0; i < n; i++){
                if(hasCycleHelper(i, visited, recStack))
                    return true;
            }
            return false;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for(int [] condition : prerequisites)
            graph.addEdge(condition[1], condition[0]);
        return !graph.hasCycle();
    }
}
