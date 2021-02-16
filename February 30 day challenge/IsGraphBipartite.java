import java.io.*;
import java.util.*;

public class IsGraphBipartite {
    int[] colorOfVertex;

    public boolean dfs(int vertex, int[][] graph, int currColor) {
        if (colorOfVertex[vertex] != 0)
            return currColor != colorOfVertex[vertex];
        colorOfVertex[vertex] = currColor;
        for (int neighbour : graph[vertex]) {
            if (dfs(neighbour, graph, -currColor))
                return true;
        }
        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colorOfVertex = new int[n];
        for (int i = 0; i < n; i++) {
            if (colorOfVertex[i] == 0 && dfs(i, graph, 1))
                return false;
        }
        return true;
    }
}
