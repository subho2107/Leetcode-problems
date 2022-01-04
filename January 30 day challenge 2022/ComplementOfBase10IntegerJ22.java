import java.io.*;

public class ComplementOfBase10IntegerJ22 {
    public int bitwiseComplement(int n) {
        int ans = 0, pow = 1;
        if(n == 0)
            return 1;
        while(n > 0){
            if((n&1) == 0)
                ans += pow;
            pow *= 2;
            n >>= 1;
        }
        return ans;
    }
}
