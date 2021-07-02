import java.io.*;
import java.util.*;
public class RedundantConnection {
    static class DSU{
        int [] parent, size;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++)
                parent[i] = i;
        }
        int findSet(int v){
            if(v == parent[v])
                return v;
            return parent[v] = findSet(parent[v]);
        }
        void unionSet(int a, int b){
            a = findSet(a);
            b = findSet(b);
            if(a != b){
                if(size[a] > size[b])
                    a = b^a^(b = a);
                parent[a] = b;
                size[b] += size[a];
            }
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int [] edge : edges){
            int a = edge[0]-1, b = edge[1]-1;
            if(dsu.findSet(a) == dsu.findSet(b))
                return edge;
            dsu.unionSet(a, b);
        }
        return new int[]{};
    }
}