import java.io.*;
import java.util.*;

public class LargestComponentSizeByCommonFactor2 {
    class DSU{
        int [] parent;
        int [] size;
        int max;
        DSU(int n){
            size = new int[n];
            Arrays.fill(size, 1);
            parent = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;
            max = 1;
        }
        int findParent(int u){
            if(parent[u] == u)
                return u;
            return parent[u] = findParent(parent[u]);
        }
        void union(int u, int v){
            u = findParent(u);
            v = findParent(v);
            if(u == v)
                return;
            if(size[u] < size[v])
                u = u^v^(v = u);
            parent[v] = u;
            size[u] += size[v];
            max = Math.max(max, size[u]);
        }
    }
    class Solution {
        private List<Integer> getPrimes(int num){
            List<Integer>primes = new ArrayList<>();
            for(int fact = 2; fact*fact <= num; fact++){
                if(num % fact == 0){
                    primes.add(fact);
                    while(num % fact == 0)
                        num /= fact;
                }
            }
            if(num > 1)
                primes.add(num);
            return primes;
        }
        public int largestComponentSize(int[] nums) {
            int n = nums.length;
            DSU dsu = new DSU(n);
            Map<Integer, List<Integer>>primes = new HashMap<>();
            for(int i = 0; i < n; i++){
                for(int prime : getPrimes(nums[i])){
                    if(!primes.containsKey(prime))
                        primes.put(prime, new ArrayList<>());
                    primes.get(prime).add(i);
                }
            }
            for(int num : primes.keySet()){
                for(int i = 0; i < primes.get(num).size()-1; i++){
                    dsu.union(primes.get(num).get(i), primes.get(num).get(i+1));
                }
            }
            return dsu.max;
        }
    }
}
