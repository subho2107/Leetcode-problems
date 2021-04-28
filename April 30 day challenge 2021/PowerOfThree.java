import java.io.*;
import java.util.*;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        int cubeRoot = (int)(Math.log10(n)/Math.log10(3));
        return Math.pow(3, cubeRoot) == n;
    }
}
