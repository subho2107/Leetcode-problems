import java.io.*;
import java.util.*;

public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int sum = 0, start = 1;
        for(int i = 7, j = 0; j < n; j ++,i++){
            if(i % 7 == 0)
                start = i/7;
            sum += start;
            start++;
        }
        return sum;
    }
}
