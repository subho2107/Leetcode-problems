import java.io.*;
import java.util.*;

public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int [] factorial = new int[n];
        factorial[0] = 1;
        for (int pos = 1; pos < n; pos++) {
            arr.add(pos);
            factorial[pos] = factorial[pos-1] * pos;
        }
        arr.add(n);
        String ans = "";
        int size = n-1;
        k--;
        while ( arr.size()>=1)
        {
            int index = k/factorial[size];
            k = k % factorial[size];
            ans += Integer.toString(arr.get(index));
            arr.remove(index);
            size--;
        }
        return ans;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        int n = Integer.parseInt(inp[0]), k = Integer.parseInt(inp[1]);
        System.out.println(new Permutation_Sequence().getPermutation(n,k));
    }
}
