import java.io.*;
import java.util.*;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>nums = new ArrayList<>();
        for (int digits = Integer.toString(low).length(); digits <= Integer.toString(high).length(); digits++) {
            int lastStartingDig = 10 - digits;
            for (int startingDig = 1; startingDig <= lastStartingDig; startingDig++) {
                int num = 0;
                for (int dig = startingDig; Integer.toString(num).length() != digits ; dig++) {
                    num = num*10+dig;
                }
                if (num < low || num > high)
                    continue;
                nums.add(num);
            }
        }
        return nums;
    }
}
