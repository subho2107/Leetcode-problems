import java.io.*;
import java.sql.Array;
import java.util.*;

public class AllPathsFromSourceToTarget {
    List<List<Integer>> paths;
    Set<Integer>visited;
    public void dfs(int index, int[][]graph, ArrayList<Integer>currPath){
        if (index!=graph.length-1)
            this.visited.add(index);
        currPath.add(index);
        if (graph[index].length==0){
            if (index==graph.length-1) {
                ArrayList<Integer>temp = new ArrayList<>(currPath);
                this.paths.add(temp);
            }
        }
        else {
            for (int neighbour :
                    graph[index]) {
                if (!this.visited.contains(neighbour))
                    dfs(neighbour, graph, currPath);
                currPath.remove(currPath.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        paths = new ArrayList<>();
        visited = new HashSet<>();
        ArrayList<Integer>currPath= new ArrayList<>();
        dfs(0, graph, currPath);
        return paths;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [][] graph = {{4,3,1}, {3,2,4}, {3}, {}};
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
        System.out.print(sb);
    }
}
