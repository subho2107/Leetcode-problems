import java.io.*;
import java.util.*;

public class CourseScheduleII {
    class Graph {
        int V;
        List<Integer>[] adj;

        Graph(int size) {
            V = size;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();
        }

        void addEdge(int src, int dst) {
            adj[src].add(dst);
        }

        int topologicalSortUtil(int v, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
            if (recStack[v])
                return -1;
            if (visited[v])
                return 1;
            visited[v] = true;
            recStack[v] = true;

            for (int neighbour : adj[v]) {
                if (topologicalSortUtil(neighbour, visited, recStack, stack) == -1)
                    return -1;
            }
            recStack[v] = false;
            stack.push(v);
            return 0;
        }

        int[] topologicalSort() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V], recStack = new boolean[V];
            for (int i = 0; i < V; i++)
                if (topologicalSortUtil(i, visited, recStack, stack) == -1)
                    break;

            List<Integer> list = new ArrayList<>();
            if (stack.size() == V) {
                while (!stack.empty())
                    list.add(stack.pop());
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] condition : prerequisites)
            graph.addEdge(condition[1], condition[0]);
        return graph.topologicalSort();
    }
}
