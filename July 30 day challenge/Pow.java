import java.io.*;
import java.util.*;

public class Pow {
    public double pow(double x, int n)
    {
        if(n == 0)
            return 1;
        double val = pow(x, n/2);
        if(n % 2 == 0)
            return val * val;
        else
            return val * val * x;
    }
    public double myPow(double x, int n) {
        if (n < 0) {
            double val = 1/pow(x, n);
            return val;
        }
        else
            return pow(x, n);
    }
}
