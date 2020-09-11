import java.io.*;
import java.util.*;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        char [] arrSecret = secret.toCharArray();
        char [] arrGuess = guess.toCharArray();
        int n = secret.length();
        for(int pos = 0; pos < n; pos++){
            if(arrSecret[pos]==arrGuess[pos]){
                A++;
                arrSecret[pos] = '-';
                arrGuess[pos] = '-';
            }
        }
        for(int pos = 0; pos < n; pos++){
            char ch = arrGuess[pos];
            if (ch == '-')continue;
            for(int pos2 = 0; pos2 < n; pos2++){
                if(arrSecret[pos2]==ch){
                    arrSecret[pos2] = '-';
                    B++;
                    break;
                }
            }
        }
        return A+"A"+B+"B";
    }
    public static void main(String[] args) throws Exception {
        new BullsAndCows().getHint("11", "10");
    }
}
