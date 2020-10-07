import java.io.*;
import java.util.*;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        char[] ch = Integer.toBinaryString(N).toCharArray();
        int res = 0;
        for(int i = 0; i < ch.length; i++){
            int num = ch[i] == '0'?1<<(ch.length-i-1):0;
            res+=num;
        }
        return res;
    }
}
