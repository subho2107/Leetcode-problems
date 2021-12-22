import java.io.*;
import java.util.*;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        while(n % 2 == 0)
            n /= 2;
        return n == 1;
    }
}
