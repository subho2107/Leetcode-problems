import java.io.*;
import java.util.*;

public class StoneGameIV {
    private boolean dfs(int n, HashMap<Integer, Boolean>prevVals){
        if(prevVals.containsKey(n)){
            return prevVals.get(n);
        }
        int root = (int)Math.sqrt(n);
        for(int i = 1; i <= root; i++){
            if(!dfs(n-i*i, prevVals)){
                prevVals.put(n, true);
                return true;
            }
        }
        prevVals.put(n, false);
        return false;
    }
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean>prevVals = new HashMap<>();
        prevVals.put(0, false);
        return dfs(n, prevVals);
    }

    public static void main(String[] args) {
        System.out.println(new StoneGameIV().winnerSquareGame(7));
    }
}
