import java.io.*;
import java.util.*;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<Integer> nums = new ArrayList<>();
        for (int dig = 1; dig < 10; dig++) {
            this.dfs(N - 1, dig, K, nums);
        }
        return nums.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(int len, int num, int diff, ArrayList<Integer> nums) {
        if (len == 0)
            nums.add(num);
        else {
            ArrayList<Integer> nextPossDigs = new ArrayList<>();
            nextPossDigs.add(num % 10 + diff);
            if (diff != 0)
                nextPossDigs.add(num % 10 - diff);
            for (Integer nextDig : nextPossDigs) {
                if (nextDig >= 0 && nextDig <= 9)
                    this.dfs(len - 1, num * 10 + nextDig, diff, nums);
            }
        }
    }
}
