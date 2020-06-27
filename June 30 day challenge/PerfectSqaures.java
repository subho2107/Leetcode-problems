import java.io.*;
import java.util.*;

public class PerfectSqaures {
    public boolean isPerfectSquare(int num)
    {
        int root = (int)Math.sqrt(num);
        if(root*root == num)
            return true;
        else
            return false;
    }
    public int numSquares(int n) {
        if(isPerfectSquare(n))return 1;
        //Legendre's three square theorem, any number other than that of the form 4^a(8b+7)
        // can be expressed as the square of three numbers
        while(n%4==0)
            n/=4;
        if(n%8==7)
            return 4;
        for(int num = 1; num*num <= n; num++)
        {
            if(isPerfectSquare(n-(num*num)))
                return 2;
        }
        return 3;

    }
}
