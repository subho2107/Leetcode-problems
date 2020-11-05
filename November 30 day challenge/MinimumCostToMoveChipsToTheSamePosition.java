import java.io.*;
import java.util.*;

public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int minCost = Integer.MAX_VALUE;
        int n = position.length;
        if(n == 1)
            return 0;
        for(int pos = 0; pos < n; pos++){
            int cost = 0;
            for(int currPos : position){
                int diff = Math.abs(currPos - 1 - pos);
                if(diff % 2 == 1)
                    cost++;
            }
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}
