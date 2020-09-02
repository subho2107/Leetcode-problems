import java.io.*;
import java.util.*;

class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int pos = 0; pos < n; pos++) {
            this.parent[pos] = pos;
        }
    }

    int findSet(int vertex) {
        if (this.parent[vertex] == vertex)
            return vertex;
        return parent[vertex] = this.findSet(parent[vertex]);
    }

    void union(int a, int b) {
        int parentA = this.findSet(a), parentB = this.findSet(b);
        parent[parentA] = parentB;
    }
}

public class LargestComponentSizeByCommonFactor {
    ArrayList<Integer> getPrimes(int num) {
        ArrayList<Integer> primes = new ArrayList<>();
        int dup = num;
        for (int fact = 2; fact * fact <= dup; fact++) {
            if (num % fact == 0) {
                primes.add(fact);
                while (num % fact == 0) {
                    num /= fact;
                }
            }
        }
        if (num > 1)
            primes.add(num);
        return primes;
    }

    public int largestComponentSize(int[] A) {
        DSU dsu = new DSU(A.length);
        HashMap<Integer, ArrayList<Integer>> sets = new HashMap<>();
        for (int pos = 0; pos < A.length; pos++) {
            ArrayList<Integer> primes = this.getPrimes(A[pos]);
            for (Integer fact : primes) {
                sets.putIfAbsent(fact, new ArrayList<>());
                sets.get(fact).add(pos);
            }
        }
        for (Integer integer : sets.keySet()) {
            for (int pos = 0; pos < sets.get(integer).size() - 1; pos++) {
                dsu.union(sets.get(integer).get(pos), sets.get(integer).get(pos+1));
            }
        }
        HashMap<Integer, Integer>freq = new HashMap<>();
        int maxSize = -1;
        for (int pos = 0; pos < A.length; pos++) {
            int parent = dsu.findSet(pos);
            freq.put(parent, freq.getOrDefault(parent, 0)+1);
            maxSize = Math.max(maxSize, freq.get(parent));
        }
        return maxSize;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        System.out.println(new LargestComponentSizeByCommonFactor().largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
        System.out.println(sb);
    }
}
