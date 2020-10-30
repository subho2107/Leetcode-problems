import java.io.*;
import java.util.*;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        ArrayList<Integer>occPos = new ArrayList<>();
        int maxDist = 0;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1)
                occPos.add(i);
        }
        maxDist = occPos.get(0);
        for(int i = 0; i < occPos.size() - 1; i++){
            maxDist = Math.max(maxDist, (occPos.get(i+1)-occPos.get(i))/2);
        }
        maxDist = Math.max(maxDist,(n-1-occPos.get(occPos.size() - 1)));
        return maxDist;
    }
}
