import java.io.*;
import java.util.*;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        for (int i = -1; i < n; i++) {
            ArrayList<Integer>list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                list.add(nums[j]);
            }
            ArrayList<Integer>dup = new ArrayList<>(list);
            Collections.sort(list);
            boolean check = true;
            for (int j = 0; j < n; j++) {
                if (!list.get(i).equals(list.get(j)))
                {
                    check = false;
                    break;
                }
            }
            for (int j = 0; j < n - 1; j++) {
                if (list.get(j).equals(list.get(j + 1))){
                    check = false;
                    break;
                }
            }
            if (check)
                return true;
        }
        return false;
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
