import java.io.*;
import java.util.*;

public class RankTransformOfAMatrix {
    static class Pair{
        private final int first;
        private final int second;
        Pair(int a, int b){
            first = a;
            second = b;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
    static class DSU{
        int [] parent;
        DSU(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int u){
            if (u == parent[u])
                return u;
            return parent[u] = find(parent[u]);
        }
        Pair union(int u, int v){
            u = find(u);
            v = find(v);
            parent[u] = v;
            return new Pair(u, v);
        }
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        Map<Integer, List<Pair>>pos = new TreeMap<>();
        int n = matrix.length, m = matrix[0].length;
        int [] rank = new int[n+m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                pos.computeIfAbsent(matrix[i][j], x->new ArrayList<>()).add(new Pair(i, j));
        for (int val : pos.keySet()) {
            DSU dsu = new DSU(n+m);
            int [] updatedRank = rank.clone();
            for (Pair pair : pos.get(val)) {
                int row = pair.getFirst(), col = pair.getSecond();
                Pair parents = dsu.union(row, col+n);
                updatedRank[parents.getSecond()] = Math.max(updatedRank[parents.getSecond()], updatedRank[parents.getFirst()]);
            }
            for (Pair pair : pos.get(val)) {
                rank[pair.getFirst()] = rank[pair.getSecond()+n] = matrix[pair.getFirst()][pair.getSecond()] = updatedRank[dsu.find(pair.getFirst())]+1;
            }
        }
        return matrix;
    }
}
