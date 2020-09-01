import java.io.*;
import java.util.*;

public class LargestComponentSizeByCommonFactor {
    ArrayList<ArrayList<Integer>> graph;
    HashSet<Integer> visited;
    int cnt;
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public void dfs(int vertex){
        if (visited.contains(vertex))return;
        cnt++;
        visited.add(vertex);
        for (int nbr:graph.get(vertex)){
            dfs(nbr);
        }
    }
    public int largestComponentSize(int[] A) {
        visited = new HashSet<>();
        graph = new ArrayList<>();
        for (int pos = 0; pos < A.length; pos++) {
            graph.add(new ArrayList<>());
        }
        int maxGrp = -1;
        for (int pos = 0; pos < A.length; pos++) {
            for (int pos2 = pos + 1; pos2 < A.length; pos2++) {
                if (gcd(A[pos], A[pos2]) != 1) {
                    graph.get(pos).add(pos2);
                    graph.get(pos2).add(pos);
                }
            }
        }
        for (int pos = 0; pos < A.length; pos++) {
            cnt = 0;
            if (visited.contains(pos))continue;
            dfs(pos);
            maxGrp = Math.max(maxGrp, cnt);
        }
        return maxGrp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(new LargestComponentSizeByCommonFactor().largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
        System.out.println(sb);
    }
}
