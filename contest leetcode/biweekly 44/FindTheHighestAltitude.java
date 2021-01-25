import java.io.*;
import java.util.*;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = gain[0];
        for (int num : gain) {
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {

        }
        System.out.println(sb);
    }
}
