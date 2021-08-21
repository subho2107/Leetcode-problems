import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    class Node{
        int u, dist;
        Node(int u, int dist){
            this.u = u;
            this.dist = dist;
        }
    }
    public int modifiedDijkstra(List<Node>[]graph){
        int n = graph.length;
        int [] dist = new int[n], ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean [] vis = new boolean[n];
        int MOD = (int)(1e9+7);
        PriorityQueue<Node>queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        dist[0] = 0;
        ways[0] = 1;
        queue.add(new Node(0, 0));
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int currVertex = curr.u, currDist = curr.dist;
            if(vis[currVertex])
                continue;
            vis[currVertex] = true;
            for(Node neighbour : graph[currVertex]){
                int v = neighbour.u, time = neighbour.dist;
                if(dist[v] > currDist+time){
                    dist[v] = currDist+time;
                    ways[v] = ways[currVertex];
                    queue.add(new Node(v, dist[v]));
                }
                else if(dist[v] == currDist+time)
                    ways[v] = (ways[v] + ways[currVertex])%MOD;
            }
        }
        return ways[n-1];
    }
    public int countPaths(int n, int[][] roads) {
        List<Node>[]graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int[] road : roads){
            int u = road[0], v = road[1], weight = road[2];
            graph[u].add(new Node(v, weight));
            graph[v].add(new Node(u, weight));
        }
        return modifiedDijkstra(graph);
    }
}
