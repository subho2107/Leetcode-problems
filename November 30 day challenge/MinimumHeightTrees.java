import java.io.*;
import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightRoots = new ArrayList<>();
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                minHeightRoots.add(i);
            }
            return minHeightRoots;
        } else {
            Set<Integer>[] tree = new Set[n];
            for (int i = 0; i < n; i++)
                tree[i] = new HashSet<>();
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                tree[u].add(v);
                tree[v].add(u);
            }
            ArrayList<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (tree[i].size() == 1)
                    leaves.add(i);
            }
            int remainingNodes = n;
            while (remainingNodes > 2) {
                remainingNodes -= leaves.size();
                ArrayList<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    for (int neighbor : tree[leaf]) {
                        tree[neighbor].remove(leaf);
                        if (tree[neighbor].size() == 1)
                            newLeaves.add(neighbor);
                    }
                }
                leaves = newLeaves;
            }
            return leaves;
        }

    }

}
