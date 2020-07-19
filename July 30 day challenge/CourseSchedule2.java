import java.io.*;
import java.util.*;

class Graph{
    int size;
    ArrayList<Integer>[]edges;
    Set<Integer>visited;
    boolean[]activeNodes;
    Graph(int n)
    {
        this.size = n;
        this.edges = new ArrayList[n];
        this.visited = new HashSet<>();
        this.activeNodes = new boolean[n];
        for(int pos = 0; pos < n; pos++)
        {
            edges[pos] = new ArrayList<>();
        }
    }
    void buildEdge(int pointA, int pointB)
    {
        this.edges[pointA].add(pointB);
    }
    boolean hasCycleHelper(int index)
    {
        if(this.activeNodes[index])
            return true;
        if(this.visited.contains(index))
            return false;
        this.visited.add(index);
        this.activeNodes[index] = true;
        for(int neighbours: this.edges[index]){
            if(hasCycleHelper(neighbours))
                return true;
        }
        this.activeNodes[index] = false;
        return false;
    }
    boolean hasCycle()
    {
        for(int i = 0; i < this.size; i++)
        {
            if(hasCycleHelper(i))
                return true;
        }
        return false;
    }
    void topoSortHelper(int index, Stack<Integer>stack)
    {
        this.visited.add(index);
        for(int neighbour: this.edges[index]){
            if(!visited.contains(neighbour))
                topoSortHelper(neighbour, stack);
        }
        stack.push(index);
    }
    int[] topoSort()
    {
        Stack<Integer>stack = new Stack<>();
        this.visited = new HashSet<>();
        for(int pos = 0; pos < this.size; pos++){
            if(!visited.contains(pos))
                topoSortHelper(pos, stack);
        }
        int[] result = new int[this.size];
        for(int pos = 0; pos < this.size; pos++){
            result[pos] = stack.pop();
        }
        return result;
    }

}
class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph obj = new Graph(numCourses);
        for(int[]edge:prerequisites){
            obj.buildEdge(edge[1], edge[0]);
        }
        if(obj.hasCycle())
            return new int[0];
        return obj.topoSort();

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(n,arr)));
    }
}
