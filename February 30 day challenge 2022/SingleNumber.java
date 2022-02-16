import java.io.*;
import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        return xor;
    }
}
